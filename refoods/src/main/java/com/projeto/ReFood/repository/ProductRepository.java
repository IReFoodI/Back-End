package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByRestaurant_RestaurantId(Long restaurantId);

  @Query("SELECT r.fantasy FROM Product p JOIN p.restaurant r WHERE p.productId = :productId")
  String findRestaurantNameByProductId(Long productId);

}
