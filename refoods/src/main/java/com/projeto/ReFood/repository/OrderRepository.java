package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
  public List<Order> findByRestaurant_RestaurantId(Long restaurantId);

}
