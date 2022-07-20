package com.example.baemin.dto;

import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
public class OrdersFoodRequestDto {

    private Long id;

    @Min(1)
    @Max(100)
    private Integer quantity;

}
