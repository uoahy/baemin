package com.example.baemin.repository;

import com.example.baemin.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findAllByRestaurantId(Long restaurantId);

    boolean existsByRestaurantIdAndName(Long restaurantId, String name);

}
