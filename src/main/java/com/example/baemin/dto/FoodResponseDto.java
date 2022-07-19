package com.example.baemin.dto;

import com.example.baemin.domain.Food;
import lombok.Getter;

@Getter
public class FoodResponseDto {

    private Long id;
    private String name;
    private Integer price;

    public FoodResponseDto(Food food) {
        id = food.getId();
        name = food.getName();
        price = food.getPrice();
    }
}
