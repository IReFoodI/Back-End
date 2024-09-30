package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.ItensPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.ItensPedidoDTO;

import java.util.List;

@RestController
@RequestMapping("/api/itenspedido")
public class ItensPedidoController {
    
    @Autowired
    private ItensPedidoService itensPedidoService;
    
    @GetMapping
    public List<ItensPedidoDTO> getAllItensPedido() {
        return itensPedidoService.getAllItensPedidos();
    }
    
    @GetMapping("/{id_itens_pedido}")
    public ResponseEntity<ItensPedidoDTO> getItemPedidoById(@PathVariable int id_itens_pedido) {
        ItensPedidoDTO itensPedidoDTO = itensPedidoService.getItensPedidoById(id_itens_pedido);
        
        return itensPedidoDTO != null ? ResponseEntity.ok(itensPedidoDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ItensPedidoDTO createItemPedido(@RequestBody ItensPedidoDTO itensPedidoDTO) {
        return itensPedidoService.createItensPedido(itensPedidoDTO);
    }
    
    @PutMapping("/{id_itens_pedido}")
    public ResponseEntity<ItensPedidoDTO> updateItemPedido(@PathVariable int id_itens_pedido, @RequestBody ItensPedidoDTO itensPedidoDTO) {
        ItensPedidoDTO updateItemPedido = itensPedidoService.updateItensPedido(id_itens_pedido, itensPedidoDTO);
        
        return updateItemPedido != null ? ResponseEntity.ok(updateItemPedido) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_itens_pedido}")
    public ResponseEntity<Void> deleteItemPedido(@PathVariable int id_itens_pedido) {
        itensPedidoService.deleteItensPedido(id_itens_pedido);
        
        return ResponseEntity.noContent().build();
    }
}

