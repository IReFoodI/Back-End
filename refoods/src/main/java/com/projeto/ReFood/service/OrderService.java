package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.OrderItemRepository;
import com.projeto.ReFood.repository.OrderRepository;
import com.projeto.ReFood.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.projeto.ReFood.dto.OrderItemDTO;
import com.projeto.ReFood.dto.OrderRequestDTO;
import com.projeto.ReFood.dto.OrderResponseDTO;
import com.projeto.ReFood.exception.BadRequestException;
import com.projeto.ReFood.exception.GlobalExceptionHandler.NotFoundException;
import com.projeto.ReFood.model.Order;
import com.projeto.ReFood.model.OrderItem;
import com.projeto.ReFood.model.OrderItemPK;
import com.projeto.ReFood.model.Product;
import com.projeto.ReFood.model.EnumOrderStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;
  private final UtilityService utilityService;
  private final OrderItemRepository orderItemRepository;
  private final ProductRepository productRepository;

  @Transactional(readOnly = true)
  public List<OrderResponseDTO> getAllOrders() {

    return orderRepository.findAll().stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public OrderResponseDTO getOrderById(Long orderId) {

    Order order = orderRepository.findById(orderId)
        .orElseThrow(() -> new NotFoundException());

    return convertToDTO(order);
  }

  @Transactional(readOnly = true)
  public List<OrderResponseDTO> getOrdersByRestaurantId(Long restaurantId) {
    List<Order> orders = orderRepository.findByRestaurant_RestaurantId(restaurantId);

    if (orders.isEmpty()) {
      throw new NotFoundException();
    }

    return orders.stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public List<OrderResponseDTO> getOrdersByUserId(Long userId) {
    List<Order> orders = orderRepository.findByUser_UserId(userId);

    if (orders.isEmpty()) {
      throw new NotFoundException();
    }

    return orders.stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  @Transactional
  public List<OrderResponseDTO> getOrdersByUserIdAndStatus(Long userId, String orderStatus) {
    List<Order> orders = orderRepository.findByUserIdAndOrderStatus(userId, orderStatus);
    if (orders.isEmpty()) {
      throw new NotFoundException();
    }
    return orders.stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  @Transactional
  public List<OrderResponseDTO> getOrdersByRestaurantIdAndStatus(Long restaurantId, String orderStatus) {
    List<Order> orders = orderRepository.findByRestaurantIdAndOrderStatus(restaurantId, orderStatus);
    if (orders.isEmpty()) {
      throw new NotFoundException();
    }
    return orders.stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  @Transactional
  public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
    Order order = new Order();
    order.setOrderDate(orderRequestDTO.getOrderDate());
    order.setDeliveryDate(orderRequestDTO.getDeliveryDate());
    order.setOrderStatus(orderRequestDTO.getOrderStatus());
    order.setDeliveryType(orderRequestDTO.getDeliveryType());
    order.setTotalValue(orderRequestDTO.getTotalValue());

    utilityService.associateUser(order::setUser, orderRequestDTO.getUserId());
    utilityService.associateRestaurant(order::setRestaurant, orderRequestDTO.getRestaurantId());
    utilityService.associateAddress(order::setAssociatedAddress, orderRequestDTO.getAddressId());
    if (orderRequestDTO.getReviewId() != null) {
      utilityService.associateReview(order::setReview, orderRequestDTO.getReviewId());
    }
    if (orderRequestDTO.getTransactionId() != null) {
      utilityService.associateTransaction(order::setTransaction, orderRequestDTO.getTransactionId());
    }

    // Verifica a quantidade disponível em estoque para cada item do pedido
    for (OrderItemDTO itemDTO : orderRequestDTO.getOrderItems()) {
      Product product = productRepository.findById(itemDTO.productId())
          .orElseThrow(() -> new NotFoundException());

      if (product.getQuantity() < itemDTO.quantity()) {
        throw new BadRequestException(
            "Quantidade de produto insuficiente em estoque para o produto: " + product.getNameProduct());
      }
    }

    orderRepository.save(order);

    List<OrderItem> orderItems = new ArrayList<>();
    for (OrderItemDTO itemDTO : orderRequestDTO.getOrderItems()) {
      OrderItem orderItem = new OrderItem();
      orderItem.setQuantity(itemDTO.quantity());
      orderItem.setUnitValue(itemDTO.unitValue());
      orderItem.setSubtotal(itemDTO.unitValue() * itemDTO.quantity());
      orderItem.setOrder(order);

      utilityService.associateProduct(orderItem::setProduct, itemDTO.productId());

      OrderItemPK orderItemPK = new OrderItemPK(order.getOrderId(), itemDTO.productId());
      orderItem.setOrderItemId(orderItemPK);

      // Subtrai a quantidade do produto do estoque
      Product product = orderItem.getProduct();
      product.setQuantity(product.getQuantity() - itemDTO.quantity());
      productRepository.save(product);

      orderItems.add(orderItem);
    }

    orderItemRepository.saveAll(orderItems);

    List<OrderItemDTO> orderItemDTOs = orderItems.stream()
        .map(item -> new OrderItemDTO(
            item.getOrderItemId(),
            item.getQuantity(),
            item.getUnitValue(),
            item.getSubtotal(),
            item.getOrder().getOrderId(),
            item.getProduct().getProductId(),
            item.getProduct().getNameProduct()))
        .collect(Collectors.toList());

    return new OrderResponseDTO(
        order.getOrderId(),
        order.getOrderDate(),
        order.getDeliveryDate(),
        order.getOrderStatus(),
        order.getDeliveryType(),
        order.getTotalValue(),
        order.getUser().getUserId(),
        order.getRestaurant().getRestaurantId(),
        order.getAssociatedAddress().getAddressId(),
        order.getReview() != null ? order.getReview().getReviewId() : null,
        order.getTransaction() != null ? order.getTransaction().getTransactionId() : null,
        orderItemDTOs);
  }

  private OrderResponseDTO convertToDTO(Order order) {
    List<OrderItemDTO> orderItemDTOs = order.getOrderItems().stream()
        .map(item -> new OrderItemDTO(
            item.getOrderItemId(),
            item.getQuantity(),
            item.getUnitValue(),
            item.getSubtotal(),
            item.getOrder().getOrderId(),
            item.getProduct().getProductId(),
            item.getProduct().getNameProduct()))
        .collect(Collectors.toList());

    return new OrderResponseDTO(
        order.getOrderId(),
        order.getOrderDate(),
        order.getDeliveryDate(),
        order.getOrderStatus(),
        order.getDeliveryType(),
        order.getTotalValue(),
        order.getUser().getUserId(),
        order.getRestaurant().getRestaurantId(),
        order.getAssociatedAddress().getAddressId(),
        order.getReview() != null ? order.getReview().getReviewId() : null,
        order.getTransaction() != null ? order.getTransaction().getTransactionId() : null,
        orderItemDTOs);
  }
  
  @Transactional
  public OrderResponseDTO updateOrderStatus(Long orderId, EnumOrderStatus newStatus) {
    Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new NotFoundException());
    order.setOrderStatus(newStatus);
    order = orderRepository.save(order);
    return convertToDTO(order);
  }
}
