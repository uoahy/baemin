package com.example.baemin.controller;

import com.example.baemin.dto.OrdersRequestDto;
import com.example.baemin.dto.OrdersResponseDto;
import com.example.baemin.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrdersController {

    private final OrdersService orderService;

    @PostMapping("/order/request")
    public ResponseEntity<OrdersResponseDto> postOrder(@RequestBody OrdersRequestDto orderRequestDto) {
        OrdersResponseDto orderResponseDto = orderService.placeOrder(orderRequestDto);
        return new ResponseEntity<>(orderResponseDto, HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrdersResponseDto>> getOrders() {
        List<OrdersResponseDto> orderResponseDtoList = orderService.getOrders();
        return new ResponseEntity<>(orderResponseDtoList, HttpStatus.OK);
    }

}
