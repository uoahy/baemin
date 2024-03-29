package com.example.baemin.service;

import com.example.baemin.domain.Food;
import com.example.baemin.domain.Orders;
import com.example.baemin.domain.Restaurant;
import com.example.baemin.dto.OrdersFoodRequestDto;
import com.example.baemin.dto.OrdersRequestDto;
import com.example.baemin.dto.OrdersResponseDto;
import com.example.baemin.repository.FoodRepository;
import com.example.baemin.repository.OrdersRepository;
import com.example.baemin.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    private final RestaurantRepository restaurantRepository;

    private final FoodRepository foodRepository;

    public OrdersResponseDto placeOrder(OrdersRequestDto ordersRequestDto) {
        Restaurant restaurant = restaurantRepository.findById(ordersRequestDto.getRestaurantId())
                .orElseThrow(() -> new IllegalArgumentException("음식점을 찾을 수 없습니다."));
        Orders orders = new Orders(restaurant);
        for (OrdersFoodRequestDto ordersFoodRequestDto : ordersRequestDto.getFoods()) {
            Food food = foodRepository.findById(ordersFoodRequestDto.getId())
                    .orElseThrow(() -> new IllegalArgumentException("음식을 찾을 수 없습니다."));
            orders.addOrdersFood(food, ordersFoodRequestDto.getQuantity());
        }
        orders.validateOrderPrice();
        return new OrdersResponseDto(ordersRepository.save(orders));
    }

    public List<OrdersResponseDto> getOrders() {
        List<Orders> ordersList = ordersRepository.findAll();
        return ordersList.stream()
                .map(OrdersResponseDto::new)
                .collect(Collectors.toList());
    }

}
