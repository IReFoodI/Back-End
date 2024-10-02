package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.ItemsOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.ItemsOrdersDTO;
import com.projeto.ReFood.model.ItemsOrders;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemsOrdersService {
    
    @Autowired
    private ItemsOrdersRepository itemsOrdersRepository;
    
    public List<ItemsOrdersDTO> getAllItensPedidos() {
        return itemsOrdersRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public ItemsOrdersDTO getItensPedidoById(int idItensPedido) {
        Optional<ItemsOrders> itensPedido = itemsOrdersRepository.findById(idItensPedido);
        return itensPedido.map(this::convertToDTO).orElse(null);
    }
    
    public ItemsOrdersDTO createItensPedido(ItemsOrdersDTO itemsOrdersDTO) {
        ItemsOrders itemsOrders = new ItemsOrders();
        
        itemsOrders.setQuantidade(itemsOrdersDTO.getQuantidade());
        itemsOrders.setDescricao(itemsOrdersDTO.getDescricao());
        itemsOrdersRepository.save(itemsOrders);
        return convertToDTO(itemsOrders);
    }
    
    public ItemsOrdersDTO updateItensPedido(int idItensPedido, ItemsOrdersDTO itemsOrdersDTO) {
        Optional<ItemsOrders> itensPedidoOptional = itemsOrdersRepository.findById(idItensPedido);
        
        if (itensPedidoOptional.isPresent()) {
            ItemsOrders itemsOrders = itensPedidoOptional.get();
            
            itemsOrders.setQuantidade(itemsOrdersDTO.getQuantidade());
            itemsOrders.setDescricao(itemsOrdersDTO.getDescricao());
            
            itemsOrdersRepository.save(itemsOrders);
            
            return convertToDTO(itemsOrders);
        }
        
        return null;
    }
    
    public void deleteItensPedido(int idItensPedido) {
        itemsOrdersRepository.deleteById(idItensPedido);
    }
    
    private ItemsOrdersDTO convertToDTO(ItemsOrders itemsOrders) {
        ItemsOrdersDTO itemsOrdersDTO = new ItemsOrdersDTO();
        
        itemsOrdersDTO.setIdItensPedido(itemsOrders.getIdItensPedido());
        itemsOrdersDTO.setQuantidade(itemsOrders.getQuantidade());
        itemsOrdersDTO.setDescricao(itemsOrders.getDescricao());
        
        return itemsOrdersDTO;
    }
}
