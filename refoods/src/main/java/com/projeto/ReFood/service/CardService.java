package com.projeto.ReFood.service;

import com.projeto.ReFood.dto.CardDTO;
import com.projeto.ReFood.model.Card;
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
    
    public List<CardDTO> getAllCards(){
        return cardRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public CardDTO getCardById(int id_card){
        Optional<Card> card = cardRepository.findById(id_card);
        return card.map(this::convertToDTO).orElse(null);
    }
    
    public CardDTO createCard(CardDTO cardDTO){
        Card card = new Card();
        
        card.setNumber(cardDTO.getNumber());
        card.setValidity(cardDTO.getValidity());
        card.setCvv(cardDTO.getCvv());
        cardRepository.save(card);
        return convertToDTO(card);
    }
    
    public CardDTO updateCard(int id_card, CardDTO cardDTO){
        Optional<Card> cardOptional = cardRepository.findById(id_card);
        
        if(cardOptional.isPresent()){
            Card card = cardOptional.get();

            card.setNumber(cardDTO.getNumber());
            card.setValidity(cardDTO.getValidity());
            card.setCvv(cardDTO.getCvv());
            cardRepository.save(card);
            
            return convertToDTO(card);
        }
        
        return null;
    }
    
    public void deleteCard(int id_card){
        cardRepository.deleteById(id_card);
    }
    
    private CardDTO convertToDTO(Card card){
        CardDTO cardDTO = new CardDTO();
        
        cardDTO.setId_card(card.getId_card());
        cardDTO.setNumber(card.getNumber());
        cardDTO.setValidity(card.getValidity());
        cardDTO.setCvv(card.getCvv());
        return cardDTO;
    }
}