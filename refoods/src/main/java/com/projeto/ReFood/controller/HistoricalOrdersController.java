package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.HistoricalOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.HistoricalOrdersDTO;

import java.util.List;

@RestController
@RequestMapping("/api/historicalorders")
public class HistoricalOrdersController {
    
    @Autowired
    private HistoricalOrdersService historicalOrdersService;
    
    @GetMapping
    public List<HistoricalOrdersDTO> getAllHistoricalOrders() {
        return historicalOrdersService.getAllHistoricalOrders();
    }
    
    @GetMapping("/{historical_order_id}")
    public ResponseEntity<HistoricalOrdersDTO> getHistoricalOrderById(@PathVariable int historical_order_id) {
        HistoricalOrdersDTO historicalOrdersDTO = historicalOrdersService.getHistoricalOrdersById(historical_order_id);
        
        return historicalOrdersDTO != null ? ResponseEntity.ok(historicalOrdersDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public HistoricalOrdersDTO createHistoricalOrder(@RequestBody HistoricalOrdersDTO historicalOrdersDTO) {
        return historicalOrdersService.createHistoricalOrders(historicalOrdersDTO);
    }
    
    @PutMapping("/{historical_order_id}")
    public ResponseEntity<HistoricalOrdersDTO> updateHistoricalOrder(@PathVariable int historical_order_id, @RequestBody HistoricalOrdersDTO historicalOrdersDTO) {
        HistoricalOrdersDTO updatedHistoricalOrder = historicalOrdersService.updateHistoricalOrders(historical_order_id, historicalOrdersDTO);
        
        return updatedHistoricalOrder != null ? ResponseEntity.ok(updatedHistoricalOrder) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{historical_order_id}")
    public ResponseEntity<Void> deleteHistoricalOrder(@PathVariable int historical_order_id) {
        historicalOrdersService.deleteHistoricalOrders(historical_order_id);
        
        return ResponseEntity.noContent().build();
    }
}
