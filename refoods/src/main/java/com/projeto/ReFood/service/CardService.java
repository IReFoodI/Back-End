package com.projeto.ReFood.service;

import com.projeto.ReFood.dto.CardDTO;
import com.projeto.ReFood.model.Cartao;
import com.projeto.ReFood.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CardService {
    
    @Autowired
    private CardRepository cardRepository;
    
    public List<CardDTO> getAllCartoes(){
        return cardRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public CardDTO getCartaoById(int id_cartao){
        Optional<Cartao> cartao = cardRepository.findById(id_cartao);
        return cartao.map(this::convertToDTO).orElse(null);
    }
    
    public CardDTO createCartao(CardDTO cardDTO){
        Cartao cartao = new Cartao();
        
        cartao.setNumero(cardDTO.getNumero());
        cartao.setTipo(cardDTO.getTipo());
        cartao.setBandeira(cardDTO.getBandeira());
        cardRepository.save(cartao);
        return convertToDTO(cartao);
    }
    
    public CardDTO updateCartao(int id_cartao, CardDTO cardDTO){
        Optional<Cartao> cartaoOptional = cardRepository.findById(id_cartao);
        
        if(cartaoOptional.isPresent()){
            Cartao cartao = cartaoOptional.get();

            cartao.setNumero(cardDTO.getNumero());
            cartao.setTipo(cardDTO.getTipo());
            cartao.setBandeira(cardDTO.getBandeira());
            cardRepository.save(cartao);
            
            return convertToDTO(cartao);
        }
        
        return null;
    }
    
    public void deleteCartao(int id_cartao){
        cardRepository.deleteById(id_cartao);
    }
    
    private CardDTO convertToDTO(Cartao cartao){
        CardDTO cardDTO = new CardDTO();
        
        cardDTO.setId_cartao(cartao.getId_cartao());
        cardDTO.setNumero(cartao.getNumero());
        cardDTO.setTipo(cartao.getTipo());
        cardDTO.setBandeira(cartao.getBandeira());
        return cardDTO;
    }
}