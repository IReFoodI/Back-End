package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Cartao, Integer> {}
