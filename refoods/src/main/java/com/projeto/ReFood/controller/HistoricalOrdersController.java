package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.HistoricalOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.HistoricalOrdersDTO;

import java.util.List;

@RestController
@RequestMapping("/api/historicospedidos")
public class HistoricalOrdersController {
    
    @Autowired
    private HistoricalOrdersService historicalOrdersService;
    
    @GetMapping
    public List<HistoricalOrdersDTO> getAllHistoricosPedidos() {
        return historicalOrdersService.getAllHistoricalOrders();
    }
    
    @GetMapping("/{id_historico}")
    public ResponseEntity<HistoricalOrdersDTO> getHistoricalOrdersById(@PathVariable int id_historico) {
        HistoricalOrdersDTO historicalOrdersDTO = historicalOrdersService.getHistoricalOrdersById(id_historico);
        
        return historicalOrdersDTO != null ? ResponseEntity.ok(historicalOrdersDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public HistoricalOrdersDTO createHistoricalOrders(@RequestBody HistoricalOrdersDTO historicalOrdersDTO) {
        return historicalOrdersService.createHistoricalOrders(historicalOrdersDTO);
    }
    
    @PutMapping("/{id_historico}")
    public ResponseEntity<HistoricalOrdersDTO> updateHistoricalOrders(@PathVariable int id_historico, @RequestBody HistoricalOrdersDTO historicalOrdersDTO) {
        HistoricalOrdersDTO updateHistoricalOrders = historicalOrdersService.updateHistoricalOrders(id_historico, historicalOrdersDTO);
        
        return updateHistoricalOrders != null ? ResponseEntity.ok(updateHistoricalOrders) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_historico}")
    public ResponseEntity<Void> deleteHistoricalOrders(@PathVariable int id_historico) {
        historicalOrdersService.deleteHistoricalOrders(id_historico);
        
        return ResponseEntity.noContent().build();
    }
}
