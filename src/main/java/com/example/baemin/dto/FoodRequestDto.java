package com.example.baemin.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
public class FoodRequestDto {

    @NotNull
    private String name;

    @NotNull
    @Pattern(regexp = "(10000|[1-9][0-9]{0,3})00")
    private String price;

}
