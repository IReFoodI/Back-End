package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.CardService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.ReFood.dto.CardDTO;

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

  @GetMapping("/user")
  public ResponseEntity<List<CardDTO>> getAllCardsByUserId(@RequestHeader("Authorization") String token) {
    List<CardDTO> cards = cardService.getAllCardsByUserId(token);
    return ResponseEntity.ok(cards);
  }

  //todo mexer aqui depois nesses operation
  @Operation(
      summary = "Atualiza um endereço específico do usuário",
      description = "Atualiza os detalhes de um endereço associado ao usuário autenticado, com base no token de autorização e no ID do endereço fornecidos. O corpo da requisição deve conter as novas informações do endereço.",
      responses = {
          @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso"),
          @ApiResponse(responseCode = "404", description = "Endereço ou usuário não encontrado"),
          @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos na requisição"),
          @ApiResponse(responseCode = "401", description = "Token de autorização inválido ou não fornecido")
      }
  )
  @GetMapping("/{cardId}")
  public ResponseEntity<CardDTO> getCardById(@PathVariable Long cardId) {
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
  public ResponseEntity<CardDTO> updateCard(@PathVariable Long cardId, @Valid @RequestBody CardDTO cardDTO) {
    CardDTO updatedCard = cardService.updateCard(cardId, cardDTO);
    return ResponseEntity.ok(updatedCard);
  }

  @DeleteMapping("/{cardId}")
  public ResponseEntity<Void> deleteCard(@PathVariable Long cardId) {
    cardService.deleteCard(cardId);
    return ResponseEntity.noContent().build();
  }
}