package com.example.baemin.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;
    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<OrdersFood> ordersFoods;
    @Transient
    private Integer orderPrice;
    private Integer deliveryFee;
    private Integer totalPrice;

    public Orders(Restaurant restaurant, List<OrdersFood> ordersFoods, Integer orderPrice) {
        this.restaurant = restaurant;
        this.ordersFoods = ordersFoods;
        deliveryFee = restaurant.getDeliveryFee();
        totalPrice = orderPrice + deliveryFee;
    }

    public Orders(Restaurant restaurant) {
        this.restaurant = restaurant;
        ordersFoods = new ArrayList<>();
        orderPrice = 0;
        deliveryFee = restaurant.getDeliveryFee();
    }

    public void addOrdersFood(Food food, Integer quantity) {
        ordersFoods.add(new OrdersFood(food, quantity, this));
        orderPrice += food.getPrice() * quantity;
    }

    public void validateOrderPrice() {
        if (orderPrice < restaurant.getMinOrderPrice()) {
            throw new IllegalArgumentException("주문 금액이 최소 주문 금액보다 적습니다.");
        }
        totalPrice = orderPrice + deliveryFee;
    }

}
