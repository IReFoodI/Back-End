package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Produto, Integer> {}
