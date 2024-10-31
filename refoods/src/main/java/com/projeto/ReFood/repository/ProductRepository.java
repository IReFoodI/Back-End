package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Card;
import com.projeto.ReFood.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


  @Query("SELECT p FROM Product p WHERE (p.nameProduct LIKE %:search% OR p.descriptionProduct LIKE %:search%) AND p.active=true")
  List<Product> searchProductByFilter(@Param("search") String search);
}
