package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.AddressRepository;
import com.projeto.ReFood.repository.OrderItemRepository;
import com.projeto.ReFood.repository.OrderRepository;
import com.projeto.ReFood.repository.ProductRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.projeto.ReFood.dto.OrderDTO;
import com.projeto.ReFood.dto.OrderItemDTO;
import com.projeto.ReFood.dto.OrderRequestDTO;
import com.projeto.ReFood.dto.OrderResponseDTO;
import com.projeto.ReFood.exception.GlobalExceptionHandler.NotFoundException;
import com.projeto.ReFood.model.Address;
import com.projeto.ReFood.model.Order;
import com.projeto.ReFood.model.OrderItem;
import com.projeto.ReFood.model.OrderItemPK;
import com.projeto.ReFood.model.Product;
import com.projeto.ReFood.model.Restaurant;
import com.projeto.ReFood.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;
  private final UtilityService utilityService;
  private final ProductRepository productRepository;
  private final OrderItemRepository orderItemRepository;
  private final AddressRepository addressRepository;

  @Transactional(readOnly = true)
  public List<OrderDTO> getAllOrders() {
    return orderRepository
        .findAll()
        .stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public OrderDTO getOrderById(Long orderId) {
    return orderRepository.findById(orderId)
        .map(this::convertToDTO)
        .orElseThrow(() -> new NotFoundException());
  }

  @Transactional
  public OrderDTO updateOrder(Long orderId, @Valid OrderDTO orderDTO) {
    Order order = orderRepository.findById(orderId)
        .orElseThrow(() -> new NotFoundException());

    order.setOrderDate(orderDTO.orderDate());
    order.setOrderStatus(orderDTO.orderStatus());
    order.setTotalValue(orderDTO.totalValue());

    utilityService.associateUser(order::setUser, orderDTO.userId());
    utilityService.associateRestaurant(order::setRestaurant, orderDTO.restaurantId());
    utilityService.associateAddress(order::setAssociatedAddress, orderDTO.addressId());

    order = orderRepository.save(order);
    return convertToDTO(order);
  }

  @Transactional
  public void deleteOrder(Long orderId) {
    if (!orderRepository.existsById(orderId)) {
      throw new NotFoundException();
    }
    orderRepository.deleteById(orderId);
  }

  @Transactional
public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
    Order order = new Order();
    order.setOrderDate(orderRequestDTO.getOrderDate());
    order.setOrderStatus(orderRequestDTO.getOrderStatus());
    order.setDeliveryType(orderRequestDTO.getDeliveryType());
    order.setTotalValue(orderRequestDTO.getTotalValue());

    // Associação de entidades usando UtilityService
    utilityService.associateUser(order::setUser, orderRequestDTO.getUserId());
    utilityService.associateRestaurant(order::setRestaurant, orderRequestDTO.getRestaurantId());
    utilityService.associateAddress(order::setAssociatedAddress, orderRequestDTO.getAddressId());

    orderRepository.save(order);

    List<OrderItem> orderItems = new ArrayList<>();
    for (OrderItemDTO itemDTO : orderRequestDTO.getOrderItems()) {
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(itemDTO.quantity());
        orderItem.setUnitValue(itemDTO.unitValue());
        orderItem.setSubtotal(itemDTO.unitValue() * itemDTO.quantity());
        orderItem.setOrder(order);

        // Associação de Product usando UtilityService
        utilityService.associateProduct(orderItem::setProduct, itemDTO.productId());

        OrderItemPK orderItemPK = new OrderItemPK(order.getOrderId(), itemDTO.productId());
        orderItem.setOrderItemId(orderItemPK);

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
            item.getProduct().getProductId()))
        .collect(Collectors.toList());

    return new OrderResponseDTO(
        order.getOrderId(),
        order.getOrderDate(),
        order.getOrderStatus(),
        order.getDeliveryType(),
        order.getTotalValue(),
        order.getUser().getUserId(),
        order.getRestaurant().getRestaurantId(),
        order.getAssociatedAddress().getAddressId(),
        orderItemDTOs
    );
}


  private OrderDTO convertToDTO(Order order) {
    return new OrderDTO(
        order.getOrderId(),
        order.getOrderDate(),
        order.getOrderStatus(),
        order.getDeliveryType(),
        order.getTotalValue(),
        order.getUser().getUserId(),
        order.getRestaurant().getRestaurantId(),
        order.getAssociatedAddress().getAddressId());
  }

  private Order convertToEntity(OrderDTO orderDTO) {
    Order order = new Order();
    order.setOrderId(orderDTO.orderId());
    order.setOrderDate(orderDTO.orderDate());
    order.setOrderStatus(orderDTO.orderStatus());
    order.setDeliveryType(orderDTO.deliveryType());
    order.setTotalValue(orderDTO.totalValue());
    utilityService.associateUser(order::setUser, orderDTO.userId());
    utilityService.associateRestaurant(order::setRestaurant, orderDTO.restaurantId());
    utilityService.associateAddress(order::setAssociatedAddress, orderDTO.addressId());
    return order;
  }
}
