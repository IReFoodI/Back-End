package com.projeto.ReFood.controller;

import com.projeto.ReFood.dto.HistoricalOrdersDTO;
import com.projeto.ReFood.service.HistoricalOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usersnotifications")
public class UserNotificationIdController {
    
    @Autowired
    private HistoricalOrdersService historicalOrdersService;
    
    @GetMapping
    public List<HistoricalOrdersDTO> getAllHistoricalOrders() {
        return historicalOrdersService.getAllHistoricalOrders();
    }
    
    @GetMapping("/{id_historico}")
    public ResponseEntity<HistoricalOrdersDTO> getHistoricalOrderById(@PathVariable int id_historico) {
        HistoricalOrdersDTO historicalOrdersDTO = historicalOrdersService.getHistoricalOrdersById(id_historico);
        
        return historicalOrdersDTO != null ? ResponseEntity.ok(historicalOrdersDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public HistoricalOrdersDTO createHistoricalOrder(@RequestBody HistoricalOrdersDTO historicalOrdersDTO) {
        return historicalOrdersService.createHistoricalOrders(historicalOrdersDTO);
    }
    
    @PutMapping("/{id_historico}")
    public ResponseEntity<HistoricalOrdersDTO> updateHistoricalOrder(@PathVariable int id_historico, @RequestBody HistoricalOrdersDTO historicalOrdersDTO) {
        HistoricalOrdersDTO updateHistoricalOrder = historicalOrdersService.updateHistoricalOrders(id_historico, historicalOrdersDTO);
        
        return updateHistoricalOrder != null ? ResponseEntity.ok(updateHistoricalOrder) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_historico}")
    public ResponseEntity<Void> deleteHistoricalOrder(@PathVariable int id_historico) {
        historicalOrdersService.deleteHistoricalOrders(id_historico);
        
        return ResponseEntity.noContent().build();
    }
}
