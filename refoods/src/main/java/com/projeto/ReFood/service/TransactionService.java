package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.TransactionDTO;
import com.projeto.ReFood.model.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    public List<TransactionDTO> getAllTransacoes() {
        return transactionRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public TransactionDTO getTransactionById(int idTransaction) {
        Optional<Transaction> transaction = transactionRepository.findById(idTransaction);
        return transaction.map(this::convertToDTO).orElse(null);
    }
    
    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        
        transaction.setTransaction_date(transactionDTO.getTransaction_date());
        transaction.setTransaction_value(transactionDTO.getTransaction_value());
        transactionRepository.save(transaction);
        return convertToDTO(transaction);
    }
    
    public TransactionDTO updateTransaction(int idTransaction, TransactionDTO transactionDTO) {
        Optional<Transaction> transactionOptional = transactionRepository.findById(idTransaction);
        
        if (transactionOptional.isPresent()) {
            Transaction transaction = transactionOptional.get();
            
            transaction.setTransaction_date(transactionDTO.getTransaction_date());
            transaction.setTransaction_value(transactionDTO.getTransaction_value());
            
            transactionRepository.save(transaction);
            
            return convertToDTO(transaction);
        }
        
        return null;
    }
    
    public void deleteTransaction(int idTransaction) {
        transactionRepository.deleteById(idTransaction);
    }
    
    private TransactionDTO convertToDTO(Transaction transaction) {
        TransactionDTO transactionDTO = new TransactionDTO();
        
        transactionDTO.setId_transaction(transaction.getId_transaction());
        transactionDTO.setTransaction_date(transaction.getTransaction_date());
        transactionDTO.setTransaction_value(transaction.getTransaction_value());
        
        return transactionDTO;
    }
}
