package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.HistoricoPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricalOrdersRepository extends JpaRepository<HistoricoPedido, Integer> {}
