package com.example.baemin.dto;

import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
public class OrdersRequestDto {

    @NotNull
    private Long restaurantId;

    @NotNull
    @Valid
    private List<OrdersFoodRequestDto> foods;

}
