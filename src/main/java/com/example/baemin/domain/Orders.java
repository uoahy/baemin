package com.example.baemin.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @OneToMany(mappedBy = "orders")
    private List<OrdersFood> ordersFoods;
    private Integer deliveryFee;
    private Integer totalPrice;

}
