package com.example.baemin.dto;

import com.example.baemin.domain.Restaurant;
import lombok.Getter;

@Getter
public class RestaurantResponseDto {

    private Long id;
    private String name;
    private Integer minOrderPrice;
    private Integer deliveryFee;

    public RestaurantResponseDto(Restaurant restaurant) {
        id = restaurant.getId();
        name = restaurant.getName();
        minOrderPrice = restaurant.getMinOrderPrice();
        deliveryFee = restaurant.getDeliveryFee();
    }

}
