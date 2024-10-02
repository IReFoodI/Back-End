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
        return historicalOrdersService.getAllHistoricoPedidos();
    }
    
    @GetMapping("/{id_historico}")
    public ResponseEntity<HistoricalOrdersDTO> getHistoricoPedidoById(@PathVariable int id_historico) {
        HistoricalOrdersDTO historicalOrdersDTO = historicalOrdersService.getHistoricoPedidoById(id_historico);
        
        return historicalOrdersDTO != null ? ResponseEntity.ok(historicalOrdersDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public HistoricalOrdersDTO createHistoricoPedido(@RequestBody HistoricalOrdersDTO historicalOrdersDTO) {
        return historicalOrdersService.createHistoricoPedido(historicalOrdersDTO);
    }
    
    @PutMapping("/{id_historico}")
    public ResponseEntity<HistoricalOrdersDTO> updateHistoricoPedido(@PathVariable int id_historico, @RequestBody HistoricalOrdersDTO historicalOrdersDTO) {
        HistoricalOrdersDTO updateHistoricoPedido = historicalOrdersService.updateHistoricoPedido(id_historico, historicalOrdersDTO);
        
        return updateHistoricoPedido != null ? ResponseEntity.ok(updateHistoricoPedido) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_historico}")
    public ResponseEntity<Void> deleteHistoricoPedido(@PathVariable int id_historico) {
        historicalOrdersService.deleteHistoricoPedido(id_historico);
        
        return ResponseEntity.noContent().build();
    }
}
