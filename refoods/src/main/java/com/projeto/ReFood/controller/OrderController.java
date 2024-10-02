package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.OrderDTO;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @GetMapping
    public List<OrderDTO> getAllPedidos() {
        return orderService.getAllPedidos();
    }
    
    @GetMapping("/{id_pedido}")
    public ResponseEntity<OrderDTO> getPedidoById(@PathVariable int id_pedido) {
        OrderDTO orderDTO = orderService.getPedidoById(id_pedido);
        
        return orderDTO != null ? ResponseEntity.ok(orderDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public OrderDTO createPedido(@RequestBody OrderDTO orderDTO) {
        return orderService.createPedido(orderDTO);
    }
    
    @PutMapping("/{id_pedido}")
    public ResponseEntity<OrderDTO> updatePedido(@PathVariable int id_pedido, @RequestBody OrderDTO orderDTO) {
        OrderDTO updatePedido = orderService.updatePedido(id_pedido, orderDTO);
        
        return updatePedido != null ? ResponseEntity.ok(updatePedido) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_pedido}")
    public ResponseEntity<Void> deletePedido(@PathVariable int id_pedido) {
        orderService.deletePedido(id_pedido);
        
        return ResponseEntity.noContent().build();
    }
}
