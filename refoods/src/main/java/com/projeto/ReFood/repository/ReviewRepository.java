package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Review;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
  Optional<Review> findByOrder_OrderId(Long orderId);
}
