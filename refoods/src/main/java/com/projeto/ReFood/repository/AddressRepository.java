package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Endereco, Integer> {}
