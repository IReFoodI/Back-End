package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.ReFood.dto.OrderRequestDTO;
import com.projeto.ReFood.dto.OrderResponseDTO;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @PostMapping
  public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
    OrderResponseDTO createdOrder = orderService.createOrder(orderRequestDTO);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{orderId}")
        .buildAndExpand(createdOrder.getOrderId())
        .toUri();
    return ResponseEntity.created(location).body(createdOrder);
  }

  @GetMapping
  public ResponseEntity<List<OrderResponseDTO>> listAllOrders() {
    List<OrderResponseDTO> orders = orderService.getAllOrders();
    return ResponseEntity.ok(orders);
  }

  @GetMapping("/{orderId}")
  public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable Long orderId) {
    OrderResponseDTO orderResponse = orderService.getOrderById(orderId);
    return ResponseEntity.ok(orderResponse);
  }

}
