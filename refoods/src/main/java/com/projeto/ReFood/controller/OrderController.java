package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.OrderService;

import com.projeto.ReFood.model.EnumOrderStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.ReFood.dto.OrderRequestDTO;
import com.projeto.ReFood.dto.OrderResponseDTO;
import com.projeto.ReFood.dto.OrderWithAddress;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @Operation(summary = "Cria um novo pedido", description = "Cria um novo pedido com base nas informações fornecidas.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Pedido criado com sucesso"),
      @ApiResponse(responseCode = "400", description = "Erro de solicitação")
  })
  @PostMapping
  public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
    OrderResponseDTO createdOrder = orderService.createOrder(orderRequestDTO);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{orderId}")
        .buildAndExpand(createdOrder.getOrderId())
        .toUri();
    return ResponseEntity.created(location).body(createdOrder);
  }

  @Operation(summary = "Lista todos os pedidos", description = "Retorna uma lista de todos os pedidos.")
  @ApiResponse(responseCode = "200", description = "Pedidos listados com sucesso")
  @GetMapping
  public ResponseEntity<List<OrderResponseDTO>> listAllOrders() {
    List<OrderResponseDTO> orders = orderService.getAllOrders();
    return ResponseEntity.ok(orders);
  }

  @Operation(summary = "Obtém detalhes de um pedido", description = "Retorna as informações de um pedido pelo ID.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Pedido encontrado"),
      @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
  })
  @GetMapping("/{orderId}")
  public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable Long orderId) {
    OrderResponseDTO orderResponse = orderService.getOrderById(orderId);
    return ResponseEntity.ok(orderResponse);
  }

  @Operation(summary = "Lista pedidos de um restaurante", description = "Retorna uma lista de pedidos realizados em um restaurante.")
  @ApiResponse(responseCode = "200", description = "Pedidos listados com sucesso")
  @GetMapping("/restaurant/{restaurantId}")
  public ResponseEntity<List<OrderResponseDTO>> getOrdersByRestaurantId(@PathVariable Long restaurantId) {
    List<OrderResponseDTO> orders = orderService.getOrdersByRestaurantId(restaurantId);
    return ResponseEntity.ok(orders);
  }

  @Operation(summary = "Lista pedidos de um usuário", description = "Retorna uma lista de pedidos realizados por um usuário.")
  @ApiResponse(responseCode = "200", description = "Pedidos listados com sucesso")
  @GetMapping("/user/{userId}")
  public ResponseEntity<List<OrderWithAddress>> getOrdersByUserId(@PathVariable Long userId) {
    List<OrderWithAddress> orders = orderService.getOrdersByUserId(userId);
    return ResponseEntity.ok(orders);
  }

  @Operation(summary = "Lista pedidos de um usuário com status específico", description = "Retorna os pedidos de um usuário com um status específico.")
  @ApiResponse(responseCode = "200", description = "Pedidos listados com sucesso")
  @GetMapping("/user/{userId}/status/{orderStatus}")
  public List<OrderResponseDTO> getOrdersByUserIdAndStatus(
      @Parameter(description = "ID do usuário") @PathVariable Long userId,
      @Parameter(description = "Status do pedido") @PathVariable String orderStatus) {
    return orderService.getOrdersByUserIdAndStatus(userId, orderStatus);
  }

  @Operation(summary = "Lista pedidos de um restaurante com status específico", description = "Retorna os pedidos de um restaurante com um status específico.")
  @ApiResponse(responseCode = "200", description = "Pedidos listados com sucesso")
  @GetMapping("/restaurant/{restaurantId}/status/{orderStatus}")
  public List<OrderResponseDTO> getOrdersByRestaurantIdAndStatus(
      @Parameter(description = "ID do restaurante") @PathVariable Long restaurantId,
      @Parameter(description = "Status do pedido") @PathVariable String orderStatus) {
    return orderService.getOrdersByRestaurantIdAndStatus(restaurantId, orderStatus);
  }
  
  @Operation(summary = "Atualiza o status de um pedido", description = "Atualiza o status do pedido com base no ID.")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Status do pedido atualizado com sucesso"),
          @ApiResponse(responseCode = "404", description = "Pedido não encontrado")
  })
  @PatchMapping("/{orderId}/status")
  public ResponseEntity<OrderResponseDTO> updateOrderStatus(
          @PathVariable Long orderId,
          @RequestParam EnumOrderStatus newStatus) {
    
    OrderResponseDTO updatedOrder = orderService.updateOrderStatus(orderId, newStatus);
    return ResponseEntity.ok(updatedOrder);
  }
}
