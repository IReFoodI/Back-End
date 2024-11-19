package com.projeto.ReFood.repository;

import com.projeto.ReFood.model.Order;
import com.projeto.ReFood.model.OrderItem;
import com.projeto.ReFood.model.OrderItemPK;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
  void deleteAllByOrder(Order order);

  // List<OrderItem> findByOrder_OrderByOrderItemId(Long orderId);
  List<OrderItem> findByOrder_OrderId(Long orderId);

}
