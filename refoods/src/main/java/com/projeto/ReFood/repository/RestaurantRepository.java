package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {}
