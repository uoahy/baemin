package com.example.baemin.service;

import com.example.baemin.domain.Food;
import com.example.baemin.domain.Restaurant;
import com.example.baemin.dto.FoodRequestDto;
import com.example.baemin.dto.FoodResponseDto;
import com.example.baemin.repository.FoodRepository;
import com.example.baemin.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FoodService {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public List<FoodResponseDto> registerFoods(List<FoodRequestDto> foodRequestDtoList, Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("음식점을 찾을 수 없습니다."));
        List<FoodResponseDto> foodResponseDtoList = new ArrayList<>();
        for (FoodRequestDto foodRequestDto : foodRequestDtoList) {
            if (foodRepository.existsByRestaurantIdAndName(restaurantId, foodRequestDto.getName())) {
                throw new IllegalArgumentException("이미 사용중인 음식 이름입니다.");
            }
            Food food = foodRepository.save(new Food(foodRequestDto, restaurant));
            foodResponseDtoList.add(new FoodResponseDto(food));
        }
        return foodResponseDtoList;
    }

    public List<FoodResponseDto> getFoods(Long restaurantId) {
        List<Food> foodList = foodRepository.findAllByRestaurantId(restaurantId);
        return foodList.stream()
                .map(FoodResponseDto::new)
                .collect(Collectors.toList());
    }
}
