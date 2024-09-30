package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.PedidoDTO;
import com.projeto.ReFood.model.Pedido;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    public List<PedidoDTO> getAllPedidos() {
        return pedidoRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public PedidoDTO getPedidoById(int idPedido) {
        Optional<Pedido> pedido = pedidoRepository.findById(idPedido);
        return pedido.map(this::convertToDTO).orElse(null);
    }
    
    public PedidoDTO createPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        
        pedido.setValorTotal(pedidoDTO.getValorTotal());
        pedido.setDataPedido(pedidoDTO.getDataPedido());
        pedidoRepository.save(pedido);
        return convertToDTO(pedido);
    }
    
    public PedidoDTO updatePedido(int idPedido, PedidoDTO pedidoDTO) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(idPedido);
        
        if (pedidoOptional.isPresent()) {
            Pedido pedido = pedidoOptional.get();
            
            pedido.setValorTotal(pedidoDTO.getValorTotal());
            pedido.setDataPedido(pedidoDTO.getDataPedido());
            
            pedidoRepository.save(pedido);
            
            return convertToDTO(pedido);
        }
        
        return null;
    }
    
    public void deletePedido(int idPedido) {
        pedidoRepository.deleteById(idPedido);
    }
    
    private PedidoDTO convertToDTO(Pedido pedido) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        
        pedidoDTO.setIdPedido(pedido.getIdPedido());
        pedidoDTO.setValorTotal(pedido.getValorTotal());
        pedidoDTO.setDataPedido(pedido.getDataPedido());
        
        return pedidoDTO;
    }
}
