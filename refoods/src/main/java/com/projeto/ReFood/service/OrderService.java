package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.AddressRepository;
import com.projeto.ReFood.repository.OrderItemRepository;
import com.projeto.ReFood.repository.OrderRepository;
import com.projeto.ReFood.repository.ProductRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private UtilityService utilityService;
  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private OrderItemRepository orderItemRepository;
  @Autowired
  private AddressRepository addressRepository;

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

    User user = new User();
    user.setUserId(orderRequestDTO.getUserId());
    order.setUser(user);

    Restaurant restaurant = new Restaurant();
    restaurant.setRestaurantId(orderRequestDTO.getRestaurantId());
    order.setRestaurant(restaurant);

    Address address = addressRepository.findById(orderRequestDTO.getAddressId())
        .orElseThrow(() -> new RuntimeException("Address not found"));
    order.setAssociatedAddress(address);

    orderRepository.save(order);

    List<OrderItem> orderItems = new ArrayList<>();
    for (OrderItemDTO itemDTO : orderRequestDTO.getOrderItems()) {
      Product product = productRepository.findById(itemDTO.productId())
          .orElseThrow(() -> new RuntimeException("Product not found"));

      OrderItem orderItem = new OrderItem();
      orderItem.setQuantity(itemDTO.quantity());
      orderItem.setUnitValue(product.getSellPrice());
      orderItem.setSubtotal(itemDTO.unitValue() * itemDTO.quantity());
      orderItem.setOrder(order);

      OrderItemPK orderItemPK = new OrderItemPK(order.getOrderId(), product.getProductId());
      orderItem.setOrderItemId(orderItemPK);

      orderItem.setProduct(product);
      orderItems.add(orderItem);
    }

    orderItemRepository.saveAll(orderItems);

    List<OrderItemDTO> orderItemDTOs = new ArrayList<>();
    for (OrderItem orderItem : orderItems) {
      orderItemDTOs.add(new OrderItemDTO(orderItem.getOrderItemId(), orderItem.getQuantity(),
          orderItem.getUnitValue(), orderItem.getSubtotal(),
          orderItem.getOrder().getOrderId(), orderItem.getProduct().getProductId()));
    }

    return new OrderResponseDTO(
        order.getOrderId(),
        order.getOrderDate(),
        order.getOrderStatus(),
        order.getDeliveryType(),
        order.getTotalValue(),
        order.getUser().getUserId(),
        order.getRestaurant().getRestaurantId(),
        order.getAssociatedAddress().getAddressId(),
        orderItemDTOs);
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
