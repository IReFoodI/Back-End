package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.OrderDTO;
import com.projeto.ReFood.model.Order;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    public List<OrderDTO> getAllorders() {
        return orderRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public OrderDTO getorderById(int idOrder) {
        Optional<Order> order = orderRepository.findById(idOrder);
        return order.map(this::convertToDTO).orElse(null);
    }
    
    public OrderDTO createorder(OrderDTO orderDTO) {
      Order order = new Order();
        
        order.setTotal_value(orderDTO.getTotal_value());
        order.setOrder_date(orderDTO.getOrder_date());
        orderRepository.save(order);
        return convertToDTO(order);
    }
    
    public OrderDTO updateorder(int idorder, OrderDTO orderDTO) {
        Optional<Order> orderOptional = orderRepository.findById(idorder);
        
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            
            order.setTotal_value(orderDTO.getTotal_value());
            order.setOrder_date(orderDTO.getOrder_date());
            
            orderRepository.save(order);
            
            return convertToDTO(order);
        }
        
        return null;
    }
    
    public void deleteorder(int idorder) {
        orderRepository.deleteById(idorder);
    }
    
    private OrderDTO convertToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        
        orderDTO.setId_order(order.getId_order());
        orderDTO.setTotal_value(order.getTotal_value());
        orderDTO.setOrder_date(order.getOrder_date());
        
        return orderDTO;
    }
}
