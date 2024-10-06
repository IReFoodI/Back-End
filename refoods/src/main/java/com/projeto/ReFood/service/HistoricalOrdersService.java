package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.HistoricalOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.HistoricalOrdersDTO;
import com.projeto.ReFood.model.HistoricalOrders;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HistoricalOrdersService {
    
    @Autowired
    private HistoricalOrdersRepository historicalOrdersRepository;
    
    public List<HistoricalOrdersDTO> getAllHistoricalOrders() {
        return historicalOrdersRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public HistoricalOrdersDTO getHistoricalOrdersById(int idHistoricalOrders) {
        Optional<HistoricalOrders> historicalOrders = historicalOrdersRepository.findById(idHistoricalOrders);
        return historicalOrders.map(this::convertToDTO).orElse(null);
    }
    
    public HistoricalOrdersDTO createHistoricalOrders(HistoricalOrdersDTO historicalOrdersDTO) {
        HistoricalOrders historicalOrders = new HistoricalOrders();
        
        historicalOrders.setOrder_status(historicalOrdersDTO.getOrder_status());
        historicalOrders.setDate_mod(historicalOrdersDTO.getDate_mod());
        historicalOrdersRepository.save(historicalOrders);
        return convertToDTO(historicalOrders);
    }
    
    public HistoricalOrdersDTO updateHistoricalOrders(int idHistoricalOrders, HistoricalOrdersDTO historicalOrdersDTO) {
        Optional<HistoricalOrders> historicalOrdersOptional = historicalOrdersRepository.findById(idHistoricalOrders);
        
        if (historicalOrdersOptional.isPresent()) {
            HistoricalOrders historicalOrders = historicalOrdersOptional.get();
            
            historicalOrders.setOrder_status(historicalOrdersDTO.getOrder_status());
            historicalOrders.setDate_mod(historicalOrdersDTO.getDate_mod());
            
            historicalOrdersRepository.save(historicalOrders);
            
            return convertToDTO(historicalOrders);
        }
        
        return null;
    }
    
    public void deleteHistoricalOrders(int idHistoricalOrders) {
        historicalOrdersRepository.deleteById(idHistoricalOrders);
    }
    
    private HistoricalOrdersDTO convertToDTO(HistoricalOrders historicalOrders) {
        HistoricalOrdersDTO historicalOrdersDTO = new HistoricalOrdersDTO();
        
        historicalOrdersDTO.setId_history(historicalOrders.getId_history());
        historicalOrdersDTO.setOrder_status(historicalOrders.getOrder_status());
        historicalOrdersDTO.setDate_mod(historicalOrders.getDate_mod());
        
        return historicalOrdersDTO;
    }
}
