package com.projeto.ReFood.dto;

import java.util.Date;
import java.util.List;

import com.projeto.ReFood.model.EnumDeliveryType;
import com.projeto.ReFood.model.EnumOrderStatus;

public class OrderRequestDTO {
  private Date orderDate;
  private Date deliveryDate;
  private EnumOrderStatus orderStatus;
  private EnumDeliveryType deliveryType;
  private float totalValue;
  private Long userId;
  private Long restaurantId;
  private Long addressId;
  private List<OrderItemDTO> orderItems;
  
  public OrderRequestDTO() {
  }

  public OrderRequestDTO(Date orderDate, Date deliveryDate, EnumOrderStatus orderStatus, EnumDeliveryType deliveryType,
      float totalValue, Long userId, Long restaurantId, Long addressId, List<OrderItemDTO> orderItems) {
    this.orderDate = orderDate;
    this.deliveryDate = deliveryDate;
    this.orderStatus = orderStatus;
    this.deliveryType = deliveryType;
    this.totalValue = totalValue;
    this.userId = userId;
    this.restaurantId = restaurantId;
    this.addressId = addressId;
    this.orderItems = orderItems;
  }

  public Date getOrderDate() {
    return orderDate;
  }
  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }
  public EnumOrderStatus getOrderStatus() {
    return orderStatus;
  }
  public void setOrderStatus(EnumOrderStatus orderStatus) {
    this.orderStatus = orderStatus;
  }
  public Date getDeliveryDate() {
    return deliveryDate;
  }
  public void setDeliveryDate(Date deliveryDate) {
    this.deliveryDate = deliveryDate;
  }
  public EnumDeliveryType getDeliveryType() {
    return deliveryType;
  }
  public void setDeliveryType(EnumDeliveryType deliveryType) {
    this.deliveryType = deliveryType;
  }
  public float getTotalValue() {
    return totalValue;
  }
  public void setTotalValue(float totalValue) {
    this.totalValue = totalValue;
  }
  public Long getUserId() {
    return userId;
  }
  public void setUserId(Long userId) {
    this.userId = userId;
  }
  public Long getRestaurantId() {
    return restaurantId;
  }
  public void setRestaurantId(Long restaurantId) {
    this.restaurantId = restaurantId;
  }
  public Long getAddressId() {
    return addressId;
  }
  public void setAddressId(Long addressId) {
    this.addressId = addressId;
  }
  public List<OrderItemDTO> getOrderItems() {
    return orderItems;
  }
  public void setOrderItems(List<OrderItemDTO> orderItems) {
    this.orderItems = orderItems;
  }
  
}
