package com.example.baemin.service;

import com.example.baemin.domain.Restaurant;
import com.example.baemin.dto.RestaurantRequestDto;
import com.example.baemin.dto.RestaurantResponseDto;
import com.example.baemin.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantResponseDto registerRestaurant(RestaurantRequestDto restaurantRequestDto) {
        Restaurant restaurant = restaurantRepository.save(new Restaurant(restaurantRequestDto));
        return new RestaurantResponseDto(restaurant);
    }

    public List<RestaurantResponseDto> getRestaurants() {
        List<Restaurant> restaurantList = restaurantRepository.findAll();
        return restaurantList.stream()
                .map(RestaurantResponseDto::new)
                .collect(Collectors.toList());
    }

}
