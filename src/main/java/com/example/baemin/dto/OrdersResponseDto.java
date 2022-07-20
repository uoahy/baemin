package com.example.baemin.dto;

import com.example.baemin.domain.Orders;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class OrdersResponseDto {

    private String restaurantName;
    private List<OrdersFoodResponseDto> foods;
    private Integer deliveryFee;
    private Integer totalPrice;

    public OrdersResponseDto(Orders orders) {
        restaurantName = orders.getRestaurant().getName();
        foods = orders.getOrdersFoods().stream()
                .map(OrdersFoodResponseDto::new)
                .collect(Collectors.toList());
        deliveryFee = orders.getDeliveryFee();
        totalPrice = orders.getTotalPrice();
    }
}
