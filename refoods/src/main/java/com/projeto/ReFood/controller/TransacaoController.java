package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.TransacaoDTO;

import java.util.List;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {
    
    @Autowired
    private TransacaoService transacaoService;
    
    @GetMapping
    public List<TransacaoDTO> getAllTransacoes() {
        return transacaoService.getAllTransacoes();
    }
    
    @GetMapping("/{id_transacao}")
    public ResponseEntity<TransacaoDTO> getTransacaoById(@PathVariable int id_transacao) {
        TransacaoDTO transacaoDTO = transacaoService.getTransacaoById(id_transacao);
        
        return transacaoDTO != null ? ResponseEntity.ok(transacaoDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public TransacaoDTO createTransacao(@RequestBody TransacaoDTO transacaoDTO) {
        return transacaoService.createTransacao(transacaoDTO);
    }
    
    @PutMapping("/{id_transacao}")
    public ResponseEntity<TransacaoDTO> updateTransacao(@PathVariable int id_transacao, @RequestBody TransacaoDTO transacaoDTO) {
        TransacaoDTO updateTransacao = transacaoService.updateTransacao(id_transacao, transacaoDTO);
        
        return updateTransacao != null ? ResponseEntity.ok(updateTransacao) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_transacao}")
    public ResponseEntity<Void> deleteTransacao(@PathVariable int id_transacao) {
        transacaoService.deleteTransacao(id_transacao);
        
        return ResponseEntity.noContent().build();
    }
}
