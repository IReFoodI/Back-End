package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.CardDTO;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {
    
    @Autowired
    private CardService cardService;
    
    @GetMapping
    public List<CardDTO> getAllCards() {
        return cardService.getAllCards();
    }
    
    @GetMapping("/{id_card}")
    public ResponseEntity<CardDTO> getCardById(@PathVariable int id_card) {
        CardDTO cardDTO = cardService.getCardById(id_card);
        
        return cardDTO != null ? ResponseEntity.ok(cardDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public CardDTO createCard(@RequestBody CardDTO cardDTO) {
        return cardService.createCard(cardDTO);
    }
    
    @PutMapping("/{id_card}")
    public ResponseEntity<CardDTO> updateCard(@PathVariable int id_card, @RequestBody CardDTO cardDTO) {
        CardDTO updateCard = cardService.updateCard(id_card, cardDTO);
        
        return updateCard != null ? ResponseEntity.ok(updateCard) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_card}")
    public ResponseEntity<Void> deleteCard(@PathVariable int id_card) {
        cardService.deleteCard(id_card);
        
        return ResponseEntity.noContent().build();
    }
}
