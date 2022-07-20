package com.example.baemin.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrdersResponseDto {

    private String restaurantName;
    private List<OrdersFoodResponseDto> foods;

}
