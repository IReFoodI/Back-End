package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {}
