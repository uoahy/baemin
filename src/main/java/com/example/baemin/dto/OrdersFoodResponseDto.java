package com.example.baemin.dto;

import com.example.baemin.domain.OrdersFood;
import lombok.Getter;

@Getter
public class OrdersFoodResponseDto {

    private String name;
    private Integer price;
    private Integer quantity;

    public OrdersFoodResponseDto(OrdersFood ordersFood) {
        name = ordersFood.getName();
        price = ordersFood.getPrice() * ordersFood.getQuantity();
        quantity = ordersFood.getQuantity();
    }

}
