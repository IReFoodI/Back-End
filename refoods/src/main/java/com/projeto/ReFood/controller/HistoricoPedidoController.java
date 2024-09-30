package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.HistoricoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.HistoricoPedidoDTO;

import java.util.List;

@RestController
@RequestMapping("/api/historicospedidos")
public class HistoricoPedidoController {
    
    @Autowired
    private HistoricoPedidoService historicoPedidoService;
    
    @GetMapping
    public List<HistoricoPedidoDTO> getAllHistoricosPedidos() {
        return historicoPedidoService.getAllHistoricoPedidos();
    }
    
    @GetMapping("/{id_historico}")
    public ResponseEntity<HistoricoPedidoDTO> getHistoricoPedidoById(@PathVariable int id_historico) {
        HistoricoPedidoDTO historicoPedidoDTO = historicoPedidoService.getHistoricoPedidoById(id_historico);
        
        return historicoPedidoDTO != null ? ResponseEntity.ok(historicoPedidoDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public HistoricoPedidoDTO createHistoricoPedido(@RequestBody HistoricoPedidoDTO historicoPedidoDTO) {
        return historicoPedidoService.createHistoricoPedido(historicoPedidoDTO);
    }
    
    @PutMapping("/{id_historico}")
    public ResponseEntity<HistoricoPedidoDTO> updateHistoricoPedido(@PathVariable int id_historico, @RequestBody HistoricoPedidoDTO historicoPedidoDTO) {
        HistoricoPedidoDTO updateHistoricoPedido = historicoPedidoService.updateHistoricoPedido(id_historico, historicoPedidoDTO);
        
        return updateHistoricoPedido != null ? ResponseEntity.ok(updateHistoricoPedido) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_historico}")
    public ResponseEntity<Void> deleteHistoricoPedido(@PathVariable int id_historico) {
        historicoPedidoService.deleteHistoricoPedido(id_historico);
        
        return ResponseEntity.noContent().build();
    }
}
