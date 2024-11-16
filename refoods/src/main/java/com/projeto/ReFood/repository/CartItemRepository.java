package com.projeto.ReFood.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projeto.ReFood.model.Cart;
import com.projeto.ReFood.model.CartItem;
import com.projeto.ReFood.model.CartItemPK;
import com.projeto.ReFood.model.Product;

public interface CartItemRepository extends JpaRepository<CartItem, CartItemPK> {
  void deleteByCartItemIdCartIdAndCartItemIdProductId(Long cartId, Long productId);

  void deleteByCart_CartId(Long cartId);

  Optional<CartItem> findByCartAndProduct(Cart cart, Product product);

  @Query("SELECT ci FROM CartItem ci WHERE ci.addedAt < :expirationTime")
  List<CartItem> findExpiredItems(@Param("expirationTime") LocalDateTime expirationTime);

}
