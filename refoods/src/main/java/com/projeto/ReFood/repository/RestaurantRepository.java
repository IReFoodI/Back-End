package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
  Optional<Restaurant> findByEmail(String email);
  boolean existsByEmail(String email);
  boolean existsByCnpj(String cnpj);
  Optional<Restaurant> findByCnpj(String cnpj);

  @Query("SELECT r.email FROM Restaurant r WHERE r.id = :id")
  Optional<String> findEmailById(@Param("id") Long id);
}
