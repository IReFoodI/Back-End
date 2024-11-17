package com.projeto.ReFood.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_order_items")
public class OrderItem {

  @EmbeddedId
  private OrderItemPK orderItemId;

  @Column(nullable = false)
  private int quantity;

  @Column(nullable = false)
  private float unitValue;

  @Column(nullable = false)
  private float subtotal;

  @ManyToOne
  @MapsId("orderId")
  @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
  private Order order;

  @ManyToOne
  @MapsId("productId")
  @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
  private Product product;

  // @ManyToOne
  // @JoinColumn(name = "restaurant_id", nullable = true)
  // private Restaurant restaurant;

  // public OrderItem() {}

  // public OrderItem(Order order, Product product, int quantity, Restaurant restaurant) {
  //     this.order = order;
  //     this.product = product;
  //     this.quantity = quantity;
  //     this.restaurant = restaurant;
  // }

  @Transient
  public String getProductName() {
    return product != null ? product.getNameProduct() : null;
  }

}
