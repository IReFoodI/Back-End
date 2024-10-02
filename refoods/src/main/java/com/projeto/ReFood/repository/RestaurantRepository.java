package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurante, Integer> {}
