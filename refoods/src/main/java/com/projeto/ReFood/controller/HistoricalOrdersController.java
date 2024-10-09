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
    
    @GetMapping("/{id_historical_order}")
    public ResponseEntity<HistoricalOrdersDTO> getHistoricalOrderById(@PathVariable int id_historical_order) {
        HistoricalOrdersDTO historicalOrdersDTO = historicalOrdersService.getHistoricalOrdersById(id_historical_order);
        
        return historicalOrdersDTO != null ? ResponseEntity.ok(historicalOrdersDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public HistoricalOrdersDTO createHistoricalOrder(@RequestBody HistoricalOrdersDTO historicalOrdersDTO) {
        return historicalOrdersService.createHistoricalOrders(historicalOrdersDTO);
    }
    
    @PutMapping("/{id_historical_order}")
    public ResponseEntity<HistoricalOrdersDTO> updateHistoricalOrder(@PathVariable int id_historical_order, @RequestBody HistoricalOrdersDTO historicalOrdersDTO) {
        HistoricalOrdersDTO updatedHistoricalOrder = historicalOrdersService.updateHistoricalOrders(id_historical_order, historicalOrdersDTO);
        
        return updatedHistoricalOrder != null ? ResponseEntity.ok(updatedHistoricalOrder) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_historical_order}")
    public ResponseEntity<Void> deleteHistoricalOrder(@PathVariable int id_historical_order) {
        historicalOrdersService.deleteHistoricalOrders(id_historical_order);
        
        return ResponseEntity.noContent().build();
    }
}
