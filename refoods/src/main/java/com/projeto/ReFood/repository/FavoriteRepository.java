package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorito, Integer> {}
