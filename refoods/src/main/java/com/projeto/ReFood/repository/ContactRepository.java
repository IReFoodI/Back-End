package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contato, Integer> {}
