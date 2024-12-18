package com.projeto.ReFood.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projeto.ReFood.dto.CartTotalSumDTO;
import com.projeto.ReFood.model.Cart;
import com.projeto.ReFood.model.User;

import jakarta.persistence.Tuple;

public interface CartRepository extends JpaRepository<Cart, Long> {
  @Query(value = """
      SELECT
        ci.cart_id AS cartId,
        ci.product_id AS productId,
        p.name_product AS productName,
        p.description_product AS descriptionProduct,
        ci.quantity AS quantity,
        ci.unit_value AS unitValue,
        ci.subtotal AS subtotal
      FROM
        tb_cart_items ci
      JOIN
        tb_cart c ON ci.cart_id = c.cart_id
      JOIN
        tb_products p ON ci.product_id = p.product_id
      WHERE
        c.user_id = :userId;
        """, nativeQuery = true)
  List<Tuple> getCartItemsByUserId(@Param("userId") Long userId);

  @Query(value = """
      SELECT SUM(ci.subtotal) AS totalSum
      FROM tb_cart_items ci
      JOIN tb_cart c ON ci.cart_id = c.cart_id
      WHERE c.user_id = :userId
      """, nativeQuery = true)
  CartTotalSumDTO getSumCartByUserId(@Param("userId") Long userId);

  Optional<Cart> findByUser(User user);

  @Query(value = "SELECT COUNT(*) > 0 " +
      "FROM tb_cart_items ci " +
      "JOIN tb_cart c ON ci.cart_id = c.cart_id " +
      "JOIN tb_users u ON c.user_id = u.user_id " +
      "WHERE u.user_id = :userId AND ci.product_id = :productId", nativeQuery = true)
  boolean existsByUserIdAndProductId(@Param("userId") Long userId, @Param("productId") Long productId);

  Optional<Cart> findByUser_UserId(Long userId);

}
