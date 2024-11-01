package com.projeto.ReFood.repository;

import com.projeto.ReFood.dto.ProductRestaurantDTO;
import com.projeto.ReFood.model.EnumProductCategory;
import com.projeto.ReFood.model.EnumRestaurantCategory;
import com.projeto.ReFood.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findByRestaurant_RestaurantId(Long restaurantId);



  @Query("SELECT new com.projeto.ReFood.dto.ProductRestaurantDTO(p, r.fantasy, r.category) " +
      "FROM Product p " +
      "JOIN p.restaurant r " +
      "WHERE p.active = true " +
      "AND (:produto IS NULL OR " +
      "     LOWER(p.nameProduct) LIKE LOWER(CONCAT('%', :produto, '%')) " +
      "     OR LOWER(p.descriptionProduct) LIKE LOWER(CONCAT('%', :produto, '%')) " +
      "     OR LOWER(r.fantasy) LIKE LOWER(CONCAT('%', :produto, '%'))) " +
      "AND (:tipos IS NULL OR r.category IN :tipos) " +
      "AND (:categorias IS NULL OR p.categoryProduct IN :categorias) " +
      "AND (:preco IS NULL OR p.sellPrice <= :preco) " +
      "AND (p.quantity>0) " +
      "ORDER BY p.nameProduct ASC")
  List<ProductRestaurantDTO> findProductsByFilters(@Param("produto") String produto,
                                                   @Param("tipos") List<EnumRestaurantCategory> tipos,
                                                   @Param("categorias") List<EnumProductCategory> categorias,
                                                   @Param("preco") Float preco);

}



