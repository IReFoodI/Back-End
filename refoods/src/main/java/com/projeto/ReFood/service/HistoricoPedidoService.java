package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.HistoricoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.HistoricoPedidoDTO;
import com.projeto.ReFood.model.HistoricoPedido;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HistoricoPedidoService {
    
    @Autowired
    private HistoricoPedidoRepository historicoPedidoRepository;
    
    public List<HistoricoPedidoDTO> getAllHistoricoPedidos() {
        return historicoPedidoRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public HistoricoPedidoDTO getHistoricoPedidoById(int idHistoricoPedido) {
        Optional<HistoricoPedido> historicoPedido = historicoPedidoRepository.findById(idHistoricoPedido);
        return historicoPedido.map(this::convertToDTO).orElse(null);
    }
    
    public HistoricoPedidoDTO createHistoricoPedido(HistoricoPedidoDTO historicoPedidoDTO) {
        HistoricoPedido historicoPedido = new HistoricoPedido();
        
        historicoPedido.setDescricao(historicoPedidoDTO.getDescricao());
        historicoPedido.setData(historicoPedidoDTO.getData());
        historicoPedidoRepository.save(historicoPedido);
        return convertToDTO(historicoPedido);
    }
    
    public HistoricoPedidoDTO updateHistoricoPedido(int idHistoricoPedido, HistoricoPedidoDTO historicoPedidoDTO) {
        Optional<HistoricoPedido> historicoPedidoOptional = historicoPedidoRepository.findById(idHistoricoPedido);
        
        if (historicoPedidoOptional.isPresent()) {
            HistoricoPedido historicoPedido = historicoPedidoOptional.get();
            
            historicoPedido.setDescricao(historicoPedidoDTO.getDescricao());
            historicoPedido.setData(historicoPedidoDTO.getData());
            
            historicoPedidoRepository.save(historicoPedido);
            
            return convertToDTO(historicoPedido);
        }
        
        return null;
    }
    
    public void deleteHistoricoPedido(int idHistoricoPedido) {
        historicoPedidoRepository.deleteById(idHistoricoPedido);
    }
    
    private HistoricoPedidoDTO convertToDTO(HistoricoPedido historicoPedido) {
        HistoricoPedidoDTO historicoPedidoDTO = new HistoricoPedidoDTO();
        
        historicoPedidoDTO.setIdHistoricoPedido(historicoPedido.getIdHistoricoPedido());
        historicoPedidoDTO.setDescricao(historicoPedido.getDescricao());
        historicoPedidoDTO.setData(historicoPedido.getData());
        
        return historicoPedidoDTO;
    }
}
