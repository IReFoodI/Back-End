package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.PedidoDTO;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;
    
    @GetMapping
    public List<PedidoDTO> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }
    
    @GetMapping("/{id_pedido}")
    public ResponseEntity<PedidoDTO> getPedidoById(@PathVariable int id_pedido) {
        PedidoDTO pedidoDTO = pedidoService.getPedidoById(id_pedido);
        
        return pedidoDTO != null ? ResponseEntity.ok(pedidoDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public PedidoDTO createPedido(@RequestBody PedidoDTO pedidoDTO) {
        return pedidoService.createPedido(pedidoDTO);
    }
    
    @PutMapping("/{id_pedido}")
    public ResponseEntity<PedidoDTO> updatePedido(@PathVariable int id_pedido, @RequestBody PedidoDTO pedidoDTO) {
        PedidoDTO updatePedido = pedidoService.updatePedido(id_pedido, pedidoDTO);
        
        return updatePedido != null ? ResponseEntity.ok(updatePedido) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_pedido}")
    public ResponseEntity<Void> deletePedido(@PathVariable int id_pedido) {
        pedidoService.deletePedido(id_pedido);
        
        return ResponseEntity.noContent().build();
    }
}
