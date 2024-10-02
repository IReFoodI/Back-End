package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.TransactionDTO;
import com.projeto.ReFood.model.Transacao;

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
    
    public TransactionDTO getTransacaoById(int idTransacao) {
        Optional<Transacao> transacao = transactionRepository.findById(idTransacao);
        return transacao.map(this::convertToDTO).orElse(null);
    }
    
    public TransactionDTO createTransacao(TransactionDTO transactionDTO) {
        Transacao transacao = new Transacao();
        
        transacao.setTipo(transactionDTO.getTipo());
        transacao.setValor(transactionDTO.getValor());
        transactionRepository.save(transacao);
        return convertToDTO(transacao);
    }
    
    public TransactionDTO updateTransacao(int idTransacao, TransactionDTO transactionDTO) {
        Optional<Transacao> transacaoOptional = transactionRepository.findById(idTransacao);
        
        if (transacaoOptional.isPresent()) {
            Transacao transacao = transacaoOptional.get();
            
            transacao.setTipo(transactionDTO.getTipo());
            transacao.setValor(transactionDTO.getValor());
            
            transactionRepository.save(transacao);
            
            return convertToDTO(transacao);
        }
        
        return null;
    }
    
    public void deleteTransacao(int idTransacao) {
        transactionRepository.deleteById(idTransacao);
    }
    
    private TransactionDTO convertToDTO(Transacao transacao) {
        TransactionDTO transactionDTO = new TransactionDTO();
        
        transactionDTO.setIdTransacao(transacao.getIdTransacao());
        transactionDTO.setTipo(transacao.getTipo());
        transactionDTO.setValor(transacao.getValor());
        
        return transactionDTO;
    }
}
