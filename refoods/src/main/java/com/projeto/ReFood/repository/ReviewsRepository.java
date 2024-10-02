package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<Avaliacao, Integer> {}
