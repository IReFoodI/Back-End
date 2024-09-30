package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.ItensPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.ItensPedidoDTO;
import com.projeto.ReFood.model.ItensPedido;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItensPedidoService {
    
    @Autowired
    private ItensPedidoRepository itensPedidoRepository;
    
    public List<ItensPedidoDTO> getAllItensPedidos() {
        return itensPedidoRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public ItensPedidoDTO getItensPedidoById(int idItensPedido) {
        Optional<ItensPedido> itensPedido = itensPedidoRepository.findById(idItensPedido);
        return itensPedido.map(this::convertToDTO).orElse(null);
    }
    
    public ItensPedidoDTO createItensPedido(ItensPedidoDTO itensPedidoDTO) {
        ItensPedido itensPedido = new ItensPedido();
        
        itensPedido.setQuantidade(itensPedidoDTO.getQuantidade());
        itensPedido.setDescricao(itensPedidoDTO.getDescricao());
        itensPedidoRepository.save(itensPedido);
        return convertToDTO(itensPedido);
    }
    
    public ItensPedidoDTO updateItensPedido(int idItensPedido, ItensPedidoDTO itensPedidoDTO) {
        Optional<ItensPedido> itensPedidoOptional = itensPedidoRepository.findById(idItensPedido);
        
        if (itensPedidoOptional.isPresent()) {
            ItensPedido itensPedido = itensPedidoOptional.get();
            
            itensPedido.setQuantidade(itensPedidoDTO.getQuantidade());
            itensPedido.setDescricao(itensPedidoDTO.getDescricao());
            
            itensPedidoRepository.save(itensPedido);
            
            return convertToDTO(itensPedido);
        }
        
        return null;
    }
    
    public void deleteItensPedido(int idItensPedido) {
        itensPedidoRepository.deleteById(idItensPedido);
    }
    
    private ItensPedidoDTO convertToDTO(ItensPedido itensPedido) {
        ItensPedidoDTO itensPedidoDTO = new ItensPedidoDTO();
        
        itensPedidoDTO.setIdItensPedido(itensPedido.getIdItensPedido());
        itensPedidoDTO.setQuantidade(itensPedido.getQuantidade());
        itensPedidoDTO.setDescricao(itensPedido.getDescricao());
        
        return itensPedidoDTO;
    }
}
