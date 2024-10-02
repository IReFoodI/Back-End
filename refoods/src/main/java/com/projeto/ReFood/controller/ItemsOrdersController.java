package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.ItemsOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.ItemsOrdersDTO;

import java.util.List;

@RestController
@RequestMapping("/api/itenspedido")
public class ItemsOrdersController {
    
    @Autowired
    private ItemsOrdersService itemsOrdersService;
    
    @GetMapping
    public List<ItemsOrdersDTO> getAllItensPedido() {
        return itemsOrdersService.getAllItensPedidos();
    }
    
    @GetMapping("/{id_itens_pedido}")
    public ResponseEntity<ItemsOrdersDTO> getItemPedidoById(@PathVariable int id_itens_pedido) {
        ItemsOrdersDTO itemsOrdersDTO = itemsOrdersService.getItensPedidoById(id_itens_pedido);
        
        return itemsOrdersDTO != null ? ResponseEntity.ok(itemsOrdersDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ItemsOrdersDTO createItemPedido(@RequestBody ItemsOrdersDTO itemsOrdersDTO) {
        return itemsOrdersService.createItensPedido(itemsOrdersDTO);
    }
    
    @PutMapping("/{id_itens_pedido}")
    public ResponseEntity<ItemsOrdersDTO> updateItemPedido(@PathVariable int id_itens_pedido, @RequestBody ItemsOrdersDTO itemsOrdersDTO) {
        ItemsOrdersDTO updateItemPedido = itemsOrdersService.updateItensPedido(id_itens_pedido, itemsOrdersDTO);
        
        return updateItemPedido != null ? ResponseEntity.ok(updateItemPedido) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_itens_pedido}")
    public ResponseEntity<Void> deleteItemPedido(@PathVariable int id_itens_pedido) {
        itemsOrdersService.deleteItensPedido(id_itens_pedido);
        
        return ResponseEntity.noContent().build();
    }
}

