package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.ItemsOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.ItemsOrdersDTO;

import java.util.List;

@RestController
@RequestMapping("/api/itemsorders")
public class ItemsOrdersController {
    
    @Autowired
    private ItemsOrdersService itemsOrdersService;
    
    @GetMapping
    public List<ItemsOrdersDTO> getAllItemsOrders() {
        return itemsOrdersService.getAllItemsOrders();
    }
    
    @GetMapping("/{id_items_order}")
    public ResponseEntity<ItemsOrdersDTO> getItemOrderById(@PathVariable int id_items_order) {
        ItemsOrdersDTO itemsOrdersDTO = itemsOrdersService.getItemOrderById(id_items_order);
        
        return itemsOrdersDTO != null ? ResponseEntity.ok(itemsOrdersDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ItemsOrdersDTO createItemOrder(@RequestBody ItemsOrdersDTO itemsOrdersDTO) {
        return itemsOrdersService.createItemOrder(itemsOrdersDTO);
    }
    
    @PutMapping("/{id_items_order}")
    public ResponseEntity<ItemsOrdersDTO> updateItemOrder(@PathVariable int id_items_order, @RequestBody ItemsOrdersDTO itemsOrdersDTO) {
        ItemsOrdersDTO updatedItemOrder = itemsOrdersService.updateItemOrder(id_items_order, itemsOrdersDTO);
        
        return updatedItemOrder != null ? ResponseEntity.ok(updatedItemOrder) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_items_order}")
    public ResponseEntity<Void> deleteItemOrder(@PathVariable int id_items_order) {
        itemsOrdersService.deleteItemOrder(id_items_order);
        
        return ResponseEntity.noContent().build();
    }
}
