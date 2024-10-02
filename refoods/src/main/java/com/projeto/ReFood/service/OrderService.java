package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.OrderDTO;
import com.projeto.ReFood.model.Pedido;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    public List<OrderDTO> getAllPedidos() {
        return orderRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public OrderDTO getPedidoById(int idPedido) {
        Optional<Pedido> pedido = orderRepository.findById(idPedido);
        return pedido.map(this::convertToDTO).orElse(null);
    }
    
    public OrderDTO createPedido(OrderDTO orderDTO) {
        Pedido pedido = new Pedido();
        
        pedido.setValorTotal(orderDTO.getValorTotal());
        pedido.setDataPedido(orderDTO.getDataPedido());
        orderRepository.save(pedido);
        return convertToDTO(pedido);
    }
    
    public OrderDTO updatePedido(int idPedido, OrderDTO orderDTO) {
        Optional<Pedido> pedidoOptional = orderRepository.findById(idPedido);
        
        if (pedidoOptional.isPresent()) {
            Pedido pedido = pedidoOptional.get();
            
            pedido.setValorTotal(orderDTO.getValorTotal());
            pedido.setDataPedido(orderDTO.getDataPedido());
            
            orderRepository.save(pedido);
            
            return convertToDTO(pedido);
        }
        
        return null;
    }
    
    public void deletePedido(int idPedido) {
        orderRepository.deleteById(idPedido);
    }
    
    private OrderDTO convertToDTO(Pedido pedido) {
        OrderDTO orderDTO = new OrderDTO();
        
        orderDTO.setIdPedido(pedido.getIdPedido());
        orderDTO.setValorTotal(pedido.getValorTotal());
        orderDTO.setDataPedido(pedido.getDataPedido());
        
        return orderDTO;
    }
}
