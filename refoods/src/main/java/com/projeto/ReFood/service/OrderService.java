package com.projeto.ReFood.service;

import com.projeto.ReFood.dto.AddressDetailsDTO;
import com.projeto.ReFood.dto.HourDTO;
import com.projeto.ReFood.dto.OrderItemDTO;
import com.projeto.ReFood.dto.OrderRequestDTO;
import com.projeto.ReFood.dto.OrderResponseDTO;
import com.projeto.ReFood.dto.OrderWithAddress;
import com.projeto.ReFood.exception.BadRequestException;
import com.projeto.ReFood.exception.GlobalExceptionHandler.NotFoundException;
import com.projeto.ReFood.model.*;
import com.projeto.ReFood.repository.OrderItemRepository;
import com.projeto.ReFood.repository.OrderRepository;
import com.projeto.ReFood.repository.ProductRepository;
import com.projeto.ReFood.repository.RestaurantHoursRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;
  private final UtilityService utilityService;
  private final OrderItemRepository orderItemRepository;
  private final ProductRepository productRepository;
  private final RestaurantHoursRepository restaurantHoursRepository;

  @Transactional(readOnly = true)
  public List<OrderResponseDTO> getAllOrders() {

    return orderRepository.findAll().stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public OrderResponseDTO getOrderById(Long orderId) {

    Order order = orderRepository.findById(orderId)
        .orElseThrow(NotFoundException::new);

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
  public List<OrderWithAddress> getOrdersByUserId(Long userId) {
    List<Order> orders = orderRepository.findByUser_UserId(userId);

    if (orders.isEmpty()) {
      throw new NotFoundException();
    }

    List<OrderWithAddress> response = orders.stream()
        .map(this::convertOrderWithAddressToDTO)
        .collect(Collectors.toList());

    // adicionar timesOfTheDay ao response
    for (OrderWithAddress order : response) {
      Long restaurantId = order.getRestaurantId();

      // Buscando horário do restaurante para o dia de hoje
      DayOfWeek currentDay = LocalDate.now().getDayOfWeek();
      EnumDayOfWeek dayEnum = EnumDayOfWeek.valueOf(currentDay.name());
      RestaurantHours restaurantHour = Optional.ofNullable(
          restaurantHoursRepository.findTodayHoursByRestaurantId(restaurantId, dayEnum))
          .orElseThrow(() -> new NotFoundException());

      HourDTO timesOfTheDay = new HourDTO(
          restaurantHour.getId(),
          restaurantHour.getDayOfWeek(),
          restaurantHour.getOpeningTime(),
          restaurantHour.getClosingTime());
      order.setTimesOfTheDay(timesOfTheDay);
    }

    // buscar order items
    for (OrderWithAddress order : response) {
      List<OrderItem> orderItems = orderItemRepository.findByOrder_OrderId(order.getOrderId());
      // converter orderitem para ordemitemDTO
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

      order.setOrderItems(orderItemDTOs);
    }

    return response;

  }

  private OrderWithAddress convertOrderWithAddressToDTO(Order order) {
    OrderWithAddress orderWithAddress = new OrderWithAddress();
    orderWithAddress.setOrderId(order.getOrderId());
    orderWithAddress.setOrderDate(order.getOrderDate());
    orderWithAddress.setDeliveryDate(order.getDeliveryDate());
    orderWithAddress.setOrderStatus(order.getOrderStatus());
    orderWithAddress.setDeliveryType(order.getDeliveryType());
    orderWithAddress.setTotalValue(order.getTotalValue());
    orderWithAddress.setUserId(order.getUser().getUserId());
    orderWithAddress.setRestaurantId(order.getRestaurant().getRestaurantId());
    orderWithAddress.setReviewId(order.getReview() != null ? order.getReview().getReviewId() : null);
    orderWithAddress
        .setTransactionId(order.getTransaction() != null ? order.getTransaction().getTransactionId() : null);

    Address associatedAddress = order.getAssociatedAddress();
    if (associatedAddress != null) {
      orderWithAddress.setAddressDetails(
          new AddressDetailsDTO(
              associatedAddress.getAddressId(),
              associatedAddress.getCep(),
              associatedAddress.getState(),
              associatedAddress.getCity(),
              associatedAddress.getType(),
              associatedAddress.getDistrict(),
              associatedAddress.getStreet(),
              associatedAddress.getNumber(),
              associatedAddress.getComplement(),
              associatedAddress.getAddressType(),
              associatedAddress.isStandard()));
    }
    return orderWithAddress;
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
    // for (OrderItemDTO itemDTO : orderRequestDTO.getOrderItems()) {
    // Product product = productRepository.findById(itemDTO.productId())
    // .orElseThrow(NotFoundException::new);

    // // Adiciona informações para debug
    // System.out.println("DEBUG: Verificando estoque para o produto:");
    // System.out.println(" Produto ID: " + product.getProductId());
    // System.out.println(" Nome: " + product.getNameProduct());
    // System.out.println(" Quantidade disponível em estoque: " +
    // product.getQuantity());
    // System.out.println(" Quantidade solicitada: " + itemDTO.quantity());

    // if (product.getQuantity() < itemDTO.quantity()) {
    // throw new BadRequestException(
    // "Quantidade de produto insuficiente em estoque para o produto: " +
    // product.getNameProduct());
    // }
    // }

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
        .orElseThrow(NotFoundException::new);
    order.setOrderStatus(newStatus);
    order = orderRepository.save(order);
    return convertToDTO(order);
  }

  @Transactional
  public OrderResponseDTO cancelOrder(Long orderId) {
    // Busca o pedido pelo ID
    Order order = orderRepository.findById(orderId)
        .orElseThrow(() -> new NotFoundException());

    // Verifica se o pedido já está cancelado
    if (order.getOrderStatus() == EnumOrderStatus.CANCELADO) {
      throw new BadRequestException("O pedido já está cancelado.");
    }

    // Atualiza o status do pedido para cancelado
    order.setOrderStatus(EnumOrderStatus.CANCELADO);
    Order response =  orderRepository.save(order);

    // Retorna os produtos ao estoque
    List<OrderItem> orderItems = orderItemRepository.findByOrder_OrderId(orderId);
    for (OrderItem item : orderItems) {
      Product product = item.getProduct();
      product.setQuantity(product.getQuantity() + item.getQuantity());
      productRepository.save(product);
    }

    return convertToDTO(response);
  }

}
