package com.example.baemin.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrdersRequestDto {

    private Long restaurantId;

    private List<OrdersFoodRequestDto> foods;

}
