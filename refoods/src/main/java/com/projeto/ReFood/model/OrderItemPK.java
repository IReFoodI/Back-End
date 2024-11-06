package com.projeto.ReFood.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OrderItemPK implements Serializable {

  private Long orderId; // ID do pedido
  private Long productId; // ID do produto

  // Construtores
  public OrderItemPK() {
  }

  public OrderItemPK(Long orderId, Long productId) {
    this.orderId = orderId;
    this.productId = productId;
  }

  // Getters e Setters
  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    OrderItemPK that = (OrderItemPK) o;
    return orderId.equals(that.orderId) && productId.equals(that.productId);
  }

  @Override
  public int hashCode() {
    return 31 * orderId.hashCode() + productId.hashCode();
  }
}
