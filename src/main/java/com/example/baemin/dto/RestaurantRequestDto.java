package com.example.baemin.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
public class RestaurantRequestDto {

    @NotNull
    private String name;

    @NotNull
    @Pattern(regexp = "(1000||[1-9][0-9]{1,2})00")
    private String minOrderPrice;

    @NotNull
    @Pattern(regexp = "(1000||[1-9][05]0)?0")
    private String deliveryFee;

}
