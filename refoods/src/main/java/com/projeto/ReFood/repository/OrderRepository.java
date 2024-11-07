package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, Long> {
  public List<Order> findByRestaurant_RestaurantId(Long restaurantId);

  public List<Order> findByUser_UserId(Long userId);

  @Query(value = "SELECT * FROM tb_orders o WHERE o.user_id = :userId AND o.order_status = :orderStatus", nativeQuery = true)
  List<Order> findByUserIdAndOrderStatus(@Param("userId") Long userId, @Param("orderStatus") String orderStatus);
  
  @Query(value = "SELECT * FROM tb_orders o WHERE o.restaurant_id = :restaurantId AND o.order_status = :orderStatus", nativeQuery = true)
  List<Order> findByRestaurantIdAndOrderStatus(@Param("restaurantId") Long restaurantId, @Param("orderStatus") String orderStatus);
  

}
