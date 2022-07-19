package com.example.baemin.controller;

import com.example.baemin.dto.FoodRequestDto;
import com.example.baemin.dto.FoodResponseDto;
import com.example.baemin.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RequiredArgsConstructor
@RestController
public class FoodController {

    private final FoodService foodService;

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public ResponseEntity<List<FoodResponseDto>> postFood(@PathVariable Long restaurantId, @RequestBody @Valid List<FoodRequestDto> foodRequestDtoList) {
        List<FoodResponseDto> foodResponseDtoList = foodService.registerFoods(foodRequestDtoList, restaurantId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public ResponseEntity<List<FoodResponseDto>> getFoods(@PathVariable Long restaurantId) {
        List<FoodResponseDto> FoodResponseDtoList = foodService.getFoods(restaurantId);
        return new ResponseEntity<>(FoodResponseDtoList, HttpStatus.OK);
    }
}
