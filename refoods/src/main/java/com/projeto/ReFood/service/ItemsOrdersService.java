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
    
    public List<ItemsOrdersDTO> getAllItemsOrders() {
        return itemsOrdersRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public ItemsOrdersDTO getItemOrderById(int idItemOrder) {
        Optional<ItemsOrders> itemOrder = itemsOrdersRepository.findById(idItemOrder);
        return itemOrder.map(this::convertToDTO).orElse(null);
    }
    
    public ItemsOrdersDTO createItemOrder(ItemsOrdersDTO itemsOrdersDTO) {
        ItemsOrders itemsOrders = new ItemsOrders();
        
        itemsOrders.setAmount(itemsOrdersDTO.getAmount());
        itemsOrders.setUnit_value(itemsOrdersDTO.getUnit_value());
        itemsOrdersRepository.save(itemsOrders);
        return convertToDTO(itemsOrders);
    }
    
    public ItemsOrdersDTO updateItemOrder(int idItemOrder, ItemsOrdersDTO itemsOrdersDTO) {
        Optional<ItemsOrders> itemOrderOptional = itemsOrdersRepository.findById(idItemOrder);
        
        if (itemOrderOptional.isPresent()) {
            ItemsOrders itemsOrders = itemOrderOptional.get();
            
            itemsOrders.setAmount(itemsOrdersDTO.getAmount());
            itemsOrders.setUnit_value(itemsOrdersDTO.getUnit_value());
            
            itemsOrdersRepository.save(itemsOrders);
            
            return convertToDTO(itemsOrders);
        }
        
        return null;
    }
    
    public void deleteItemOrder(int idItemOrder) {
        itemsOrdersRepository.deleteById(idItemOrder);
    }
    
    private ItemsOrdersDTO convertToDTO(ItemsOrders itemsOrders) {
        ItemsOrdersDTO itemsOrdersDTO = new ItemsOrdersDTO();
        
        itemsOrdersDTO.setId_items_orders(itemsOrders.getId_items_orders());
        itemsOrdersDTO.setAmount(itemsOrders.getAmount());
        itemsOrdersDTO.setUnit_value(itemsOrders.getUnit_value());
        
        return itemsOrdersDTO;
    }
}
