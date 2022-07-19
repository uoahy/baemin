package com.example.baemin.domain;

import com.example.baemin.dto.FoodRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer price;
    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

    public Food(FoodRequestDto foodRequestDto, Restaurant restaurant) {
        name = foodRequestDto.getName();
        price = Integer.parseInt(foodRequestDto.getPrice());
        this.restaurant = restaurant;
    }
}
