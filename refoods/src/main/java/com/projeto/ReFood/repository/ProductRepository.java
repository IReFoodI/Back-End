package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByRestaurant_RestaurantId(Long restaurantId);
}
