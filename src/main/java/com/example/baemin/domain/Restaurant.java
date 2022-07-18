package com.example.baemin.domain;

import com.example.baemin.dto.RestaurantRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer minOrderPrice;
    private Integer deliveryFee;

    public Restaurant(RestaurantRequestDto restaurantRequestDto) {
        name = restaurantRequestDto.getName();
        minOrderPrice = Integer.parseInt(restaurantRequestDto.getMinOrderPrice());
        deliveryFee = Integer.parseInt(restaurantRequestDto.getDeliveryFee());
    }

}
