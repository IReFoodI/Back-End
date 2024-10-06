package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.OrderDTO;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }
    
    @GetMapping("/{id_order}")
    public ResponseEntity<OrderDTO> getOrdersById(@PathVariable int id_order) {
        OrderDTO orderDTO = orderService.getOrderById(id_order);
        
        return orderDTO != null ? ResponseEntity.ok(orderDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public OrderDTO createOrders(@RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }
    
    @PutMapping("/{id_order}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable int id_order, @RequestBody OrderDTO orderDTO) {
        OrderDTO updateOrder = orderService.updateOrder(id_order, orderDTO);
        
        return updateOrder != null ? ResponseEntity.ok(updateOrder) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_order}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int id_order) {
        orderService.deleteOrder(id_order);
        
        return ResponseEntity.noContent().build();
    }
}
