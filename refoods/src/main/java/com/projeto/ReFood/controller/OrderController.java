package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.OrderService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.ReFood.dto.OrderDTO;
import com.projeto.ReFood.dto.OrderRequestDTO;
import com.projeto.ReFood.dto.OrderResponseDTO;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @GetMapping
  public ResponseEntity<List<OrderDTO>> listAllOrders() {
    List<OrderDTO> orders = orderService.getAllOrders();
    return ResponseEntity.ok(orders);
  }

  @GetMapping("/{orderId}")
  public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long orderId) {
    OrderDTO orderDTO = orderService.getOrderById(orderId);
    return ResponseEntity.ok(orderDTO);
  }

  @PostMapping
  public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
    OrderResponseDTO createdOrder = orderService.createOrder(orderRequestDTO);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{orderId}")
        .buildAndExpand(createdOrder.getOrderId())
        .toUri();
    return ResponseEntity.created(location).body(createdOrder);
  }

  @PutMapping("/{orderId}")
  public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long orderId, @Valid @RequestBody OrderDTO orderDTO) {
    OrderDTO updatedOrder = orderService.updateOrder(orderId, orderDTO);
    return ResponseEntity.ok(updatedOrder);
  }

  @DeleteMapping("/{orderId}")
  public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
    orderService.deleteOrder(orderId);
    return ResponseEntity.noContent().build();
  }
}
