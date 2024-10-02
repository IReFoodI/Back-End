package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transacao, Integer> {}
