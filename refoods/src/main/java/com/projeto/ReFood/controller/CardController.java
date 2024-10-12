package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.CardService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.ReFood.dto.CardDTO;
import com.projeto.ReFood.exception.NotFoundException;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardController {

  @Autowired
  private CardService cardService;

  @GetMapping
  public ResponseEntity<List<CardDTO>> listAllCards() {
    List<CardDTO> cards = cardService.getAllCards();
    return ResponseEntity.ok(cards);
  }

  @GetMapping("/{cardId}")
  public ResponseEntity<CardDTO> getCardById(@PathVariable Long cardId) throws NotFoundException {
    CardDTO cardDTO = cardService.getCardById(cardId);
    return ResponseEntity.ok(cardDTO);
  }

  @PostMapping
  public ResponseEntity<CardDTO> createCard(@Valid @RequestBody CardDTO cardDTO) {
    CardDTO createdCard = cardService.createCard(cardDTO);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{cardId}")
        .buildAndExpand(createdCard.cardId())
        .toUri();
    return ResponseEntity.created(location).body(createdCard);
  }

  @PutMapping("/{cardId}")
  public ResponseEntity<CardDTO> updateCard(@PathVariable Long cardId, @Valid @RequestBody CardDTO cardDTO)
      throws NotFoundException {
    CardDTO updatedCard = cardService.updateCard(cardId, cardDTO);
    return ResponseEntity.ok(updatedCard);
  }

  @DeleteMapping("/{cardId}")
  public ResponseEntity<Void> deleteCard(@PathVariable Long cardId) throws NotFoundException {
    cardService.deleteCard(cardId);
    return ResponseEntity.noContent().build();
  }
}