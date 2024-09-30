package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.TransacaoDTO;
import com.projeto.ReFood.model.Transacao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransacaoService {
    
    @Autowired
    private TransacaoRepository transacaoRepository;
    
    public List<TransacaoDTO> getAllTransacoes() {
        return transacaoRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public TransacaoDTO getTransacaoById(int idTransacao) {
        Optional<Transacao> transacao = transacaoRepository.findById(idTransacao);
        return transacao.map(this::convertToDTO).orElse(null);
    }
    
    public TransacaoDTO createTransacao(TransacaoDTO transacaoDTO) {
        Transacao transacao = new Transacao();
        
        transacao.setTipo(transacaoDTO.getTipo());
        transacao.setValor(transacaoDTO.getValor());
        transacaoRepository.save(transacao);
        return convertToDTO(transacao);
    }
    
    public TransacaoDTO updateTransacao(int idTransacao, TransacaoDTO transacaoDTO) {
        Optional<Transacao> transacaoOptional = transacaoRepository.findById(idTransacao);
        
        if (transacaoOptional.isPresent()) {
            Transacao transacao = transacaoOptional.get();
            
            transacao.setTipo(transacaoDTO.getTipo());
            transacao.setValor(transacaoDTO.getValor());
            
            transacaoRepository.save(transacao);
            
            return convertToDTO(transacao);
        }
        
        return null;
    }
    
    public void deleteTransacao(int idTransacao) {
        transacaoRepository.deleteById(idTransacao);
    }
    
    private TransacaoDTO convertToDTO(Transacao transacao) {
        TransacaoDTO transacaoDTO = new TransacaoDTO();
        
        transacaoDTO.setIdTransacao(transacao.getIdTransacao());
        transacaoDTO.setTipo(transacao.getTipo());
        transacaoDTO.setValor(transacao.getValor());
        
        return transacaoDTO;
    }
}
