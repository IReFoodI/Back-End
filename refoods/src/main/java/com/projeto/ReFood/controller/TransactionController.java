package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.TransactionDTO;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;
    
    @GetMapping
    public List<TransactionDTO> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
    
    @GetMapping("/{id_transaction}")
    public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable int id_transaction) {
        TransactionDTO transactionDTO = transactionService.getTransactionById(id_transaction);
        
        return transactionDTO != null ? ResponseEntity.ok(transactionDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public TransactionDTO createTransaction(@RequestBody TransactionDTO transactionDTO) {
        return transactionService.createTransaction(transactionDTO);
    }
    
    @PutMapping("/{id_transaction}")
    public ResponseEntity<TransactionDTO> updateTransaction(@PathVariable int id_transaction, @RequestBody TransactionDTO transactionDTO) {
        TransactionDTO updateTransaction = transactionService.updateTransaction(id_transaction, transactionDTO);
        
        return updateTransaction != null ? ResponseEntity.ok(updateTransaction) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_transaction}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable int id_transaction) {
        transactionService.deleteTransaction(id_transaction);
        
        return ResponseEntity.noContent().build();
    }
}
