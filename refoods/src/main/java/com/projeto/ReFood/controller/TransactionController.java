package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.TransactionDTO;

import java.util.List;

@RestController
@RequestMapping("/api/transacoes")
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;
    
    @GetMapping
    public List<TransactionDTO> getAllTransacoes() {
        return transactionService.getAllTransacoes();
    }
    
    @GetMapping("/{id_transacao}")
    public ResponseEntity<TransactionDTO> getTransacaoById(@PathVariable int id_transacao) {
        TransactionDTO transactionDTO = transactionService.getTransacaoById(id_transacao);
        
        return transactionDTO != null ? ResponseEntity.ok(transactionDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public TransactionDTO createTransacao(@RequestBody TransactionDTO transactionDTO) {
        return transactionService.createTransacao(transactionDTO);
    }
    
    @PutMapping("/{id_transacao}")
    public ResponseEntity<TransactionDTO> updateTransacao(@PathVariable int id_transacao, @RequestBody TransactionDTO transactionDTO) {
        TransactionDTO updateTransacao = transactionService.updateTransacao(id_transacao, transactionDTO);
        
        return updateTransacao != null ? ResponseEntity.ok(updateTransacao) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_transacao}")
    public ResponseEntity<Void> deleteTransacao(@PathVariable int id_transacao) {
        transactionService.deleteTransacao(id_transacao);
        
        return ResponseEntity.noContent().build();
    }
}
