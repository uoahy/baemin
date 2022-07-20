package com.example.baemin.service;

import com.example.baemin.dto.OrdersRequestDto;
import com.example.baemin.dto.OrdersResponseDto;
import com.example.baemin.repository.FoodRepository;
import com.example.baemin.repository.OrdersRepository;
import com.example.baemin.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrdersService {

    private final OrdersRepository orderRepository;

    private final RestaurantRepository restaurantRepository;

    private final FoodRepository foodRepository;

    @Transactional
    public OrdersResponseDto placeOrder(OrdersRequestDto orderRequestDto) {
        return new OrdersResponseDto();
    }

    public List<OrdersResponseDto> getOrders() {
        return new ArrayList<>();
    }

}
