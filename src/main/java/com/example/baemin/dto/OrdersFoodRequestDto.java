package com.example.baemin.dto;

import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
public class OrdersFoodRequestDto {

    @NotNull
    private Long id;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer quantity;

}
