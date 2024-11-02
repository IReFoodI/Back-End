package com.projeto.ReFood.repository;

import com.projeto.ReFood.dto.RestaurantInfoDTO;
import com.projeto.ReFood.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByRestaurant_RestaurantId(Long restaurantId);

  @Query("SELECT r.fantasy FROM Product p JOIN p.restaurant r WHERE p.productId = :productId")
  String findRestaurantNameByProductId(Long productId);

  @Query("""
          SELECT new com.projeto.ReFood.dto.RestaurantInfoDTO(
              r.restaurantId,
              r.fantasy,
              r.email,
              r.dateCreation,
              r.category,
              r.urlBanner,
              r.urlLogo,
              r.quantityEvaluations,
              r.totalEvaluations,
              r.phone,
              r.description,
              r.averageRating
          )
          FROM Product p
          JOIN p.restaurant r
          WHERE p.productId = :productId
      """)
  RestaurantInfoDTO findRestaurantInfoByProductId(Long productId);

}
