package com.projeto.ReFood.dto;

import java.util.Date;
import java.util.List;

import com.projeto.ReFood.model.EnumDeliveryType;
import com.projeto.ReFood.model.EnumOrderStatus;

public class OrderWithAddress {
  private Long orderId;
  private Date orderDate;
  private Date deliveryDate;
  private EnumOrderStatus orderStatus;
  private EnumDeliveryType deliveryType;
  private float totalValue;
  private Long userId;
  private Long restaurantId;
  private AddressDetailsDTO addressDetails;
  private Long reviewId;
  private Long transactionId;
  private List<OrderItemDTO> orderItems;

  public OrderWithAddress() {
  }

  public OrderWithAddress(Long orderId, Date orderDate, Date deliveryDate, EnumOrderStatus orderStatus,
      EnumDeliveryType deliveryType, float totalValue, Long userId, Long restaurantId, AddressDetailsDTO addressDetails,
      Long reviewId,
      Long transactionId, List<OrderItemDTO> orderItems) {
    this.orderId = orderId;
    this.orderDate = orderDate;
    this.deliveryDate = deliveryDate;
    this.orderStatus = orderStatus;
    this.deliveryType = deliveryType;
    this.totalValue = totalValue;
    this.userId = userId;
    this.restaurantId = restaurantId;
    this.addressDetails = addressDetails;
    this.reviewId = reviewId;
    this.transactionId = transactionId;
    this.orderItems = orderItems;
  }

  public Long getReviewId() {
    return reviewId;
  }

  public void setReviewId(Long reviewId) {
    this.reviewId = reviewId;
  }

  public Long getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(Long transactionId) {
    this.transactionId = transactionId;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
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

  public AddressDetailsDTO getAddressDetails() {
    return addressDetails;
  }

  public void setAddressDetails(AddressDetailsDTO addressDetails) {
    this.addressDetails = addressDetails;
  }

  public List<OrderItemDTO> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(List<OrderItemDTO> orderItems) {
    this.orderItems = orderItems;
  }

  public Date getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(Date deliveryDate) {
    this.deliveryDate = deliveryDate;
  }
}
