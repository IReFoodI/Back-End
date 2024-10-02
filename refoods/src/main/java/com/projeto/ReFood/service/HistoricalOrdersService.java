package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.HistoricalOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.HistoricalOrdersDTO;
import com.projeto.ReFood.model.HistoricoPedido;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HistoricalOrdersService {
    
    @Autowired
    private HistoricalOrdersRepository historicalOrdersRepository;
    
    public List<HistoricalOrdersDTO> getAllHistoricoPedidos() {
        return historicalOrdersRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public HistoricalOrdersDTO getHistoricoPedidoById(int idHistoricoPedido) {
        Optional<HistoricoPedido> historicoPedido = historicalOrdersRepository.findById(idHistoricoPedido);
        return historicoPedido.map(this::convertToDTO).orElse(null);
    }
    
    public HistoricalOrdersDTO createHistoricoPedido(HistoricalOrdersDTO historicalOrdersDTO) {
        HistoricoPedido historicoPedido = new HistoricoPedido();
        
        historicoPedido.setDescricao(historicalOrdersDTO.getDescricao());
        historicoPedido.setData(historicalOrdersDTO.getData());
        historicalOrdersRepository.save(historicoPedido);
        return convertToDTO(historicoPedido);
    }
    
    public HistoricalOrdersDTO updateHistoricoPedido(int idHistoricoPedido, HistoricalOrdersDTO historicalOrdersDTO) {
        Optional<HistoricoPedido> historicoPedidoOptional = historicalOrdersRepository.findById(idHistoricoPedido);
        
        if (historicoPedidoOptional.isPresent()) {
            HistoricoPedido historicoPedido = historicoPedidoOptional.get();
            
            historicoPedido.setDescricao(historicalOrdersDTO.getDescricao());
            historicoPedido.setData(historicalOrdersDTO.getData());
            
            historicalOrdersRepository.save(historicoPedido);
            
            return convertToDTO(historicoPedido);
        }
        
        return null;
    }
    
    public void deleteHistoricoPedido(int idHistoricoPedido) {
        historicalOrdersRepository.deleteById(idHistoricoPedido);
    }
    
    private HistoricalOrdersDTO convertToDTO(HistoricoPedido historicoPedido) {
        HistoricalOrdersDTO historicalOrdersDTO = new HistoricalOrdersDTO();
        
        historicalOrdersDTO.setIdHistoricoPedido(historicoPedido.getIdHistoricoPedido());
        historicalOrdersDTO.setDescricao(historicoPedido.getDescricao());
        historicalOrdersDTO.setData(historicoPedido.getData());
        
        return historicalOrdersDTO;
    }
}
