package com.example.baemin.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class OrdersFood {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer price;
    private Integer quantity;
    @ManyToOne
    private Orders orders;

    public OrdersFood(Food food, Integer quantity, Orders orders) {
        name = food.getName();
        price = food.getPrice();
        this.quantity = quantity;
        this.orders = orders;
    }

}
