package com.example.baemin.controller;

import com.example.baemin.dto.RestaurantRequestDto;
import com.example.baemin.dto.RestaurantResponseDto;
import com.example.baemin.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/restaurant/register")
    public ResponseEntity<RestaurantResponseDto> postRestaurant(@RequestBody @Valid RestaurantRequestDto restaurantRequestDto) {
        RestaurantResponseDto restaurantResponseDto = restaurantService.registerRestaurant(restaurantRequestDto);
        return new ResponseEntity<>(restaurantResponseDto, HttpStatus.OK);
    }

    @GetMapping("/restaurants")
    public ResponseEntity<List<RestaurantResponseDto>> getRestaurants() {
        List<RestaurantResponseDto> RestaurantResponseDtoList = restaurantService.getRestaurants();
        return new ResponseEntity<>(RestaurantResponseDtoList, HttpStatus.OK);
    }
}
