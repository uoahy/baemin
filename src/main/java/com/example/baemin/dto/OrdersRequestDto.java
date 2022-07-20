package com.example.baemin.dto;

import lombok.Getter;

import javax.validation.Valid;
import java.util.List;

@Getter
public class OrdersRequestDto {
    
    private Long restaurantId;

    @Valid
    private List<OrdersFoodRequestDto> foods;

}
