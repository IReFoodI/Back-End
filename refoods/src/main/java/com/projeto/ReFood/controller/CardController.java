package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.CardDTO;

import java.util.List;

@RestController
@RequestMapping("/api/cartoes")
public class CardController {
    
    @Autowired
    private CardService cardService;
    
    @GetMapping
    public List<CardDTO> getAllCartoes() {
        return cardService.getAllCartoes();
    }
    
    @GetMapping("/{id_cartao}")
    public ResponseEntity<CardDTO> getCartaoById(@PathVariable int id_cartao) {
        CardDTO cardDTO = cardService.getCartaoById(id_cartao);
        
        return cardDTO != null ? ResponseEntity.ok(cardDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public CardDTO createCartao(@RequestBody CardDTO cardDTO) {
        return cardService.createCartao(cardDTO);
    }
    
    @PutMapping("/{id_cartao}")
    public ResponseEntity<CardDTO> updateCartao(@PathVariable int id_cartao, @RequestBody CardDTO cardDTO) {
        CardDTO updateCartao = cardService.updateCartao(id_cartao, cardDTO);
        
        return updateCartao != null ? ResponseEntity.ok(updateCartao) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_cartao}")
    public ResponseEntity<Void> deleteCartao(@PathVariable int id_cartao) {
        cardService.deleteCartao(id_cartao);
        
        return ResponseEntity.noContent().build();
    }
}
