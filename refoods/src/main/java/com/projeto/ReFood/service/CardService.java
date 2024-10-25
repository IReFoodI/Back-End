package com.projeto.ReFood.service;

import com.projeto.ReFood.dto.CardDTO;
import com.projeto.ReFood.exception.GlobalExceptionHandler;
import com.projeto.ReFood.exception.GlobalExceptionHandler.NotFoundException;
import com.projeto.ReFood.model.Card;
import com.projeto.ReFood.model.UserInfo;
import com.projeto.ReFood.repository.CardRepository;
import com.projeto.ReFood.security.JwtTokenProvider;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
public class CardService {

  @Autowired
  private CardRepository cardRepository;
  @Autowired
  private UtilityService utilityService;
  @Autowired
  private JwtTokenProvider jwtTokenProvider;
  @Autowired
  private final AuthService authService;

  @Transactional(readOnly = true)
  public List<CardDTO> getAllCardsByUserId(String token) {
    Long id = jwtTokenProvider.extractUserId(token);
    return cardRepository
        .findCardByUserId(id)
        .stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public CardDTO getCardById(String token, Long cardId) {
    UserInfo currentUserInfo = authService.getCurrentUserInfo();
    Long id = jwtTokenProvider.extractUserId(token);
    if (currentUserInfo.getId() == null) {
      throw new GlobalExceptionHandler.ForbiddenException();
    }
    return cardRepository.findByIdAndUserId(cardId, id)
        .map(this::convertToDTO)
        .orElseThrow(() -> new NotFoundException());
  }

  @Transactional
  public CardDTO createCard(String token, @Valid CardDTO cardDTO) {
    UserInfo currentUserInfo = authService.getCurrentUserInfo();
    Long id = jwtTokenProvider.extractUserId(token);
    Card card = convertToEntity(cardDTO);

    if (currentUserInfo.getId() == null) {
      throw new GlobalExceptionHandler.ForbiddenException();
    }
    utilityService.associateUser(card::setUser, cardDTO.userId());
    card = cardRepository.save(card);
    return convertToDTO(card);
  }

  @Transactional
  public CardDTO updateCard(String token, Long cardId, @Valid CardDTO cardDTO) {
    Long id = jwtTokenProvider.extractUserId(token);
    UserInfo currentUserInfo = authService.getCurrentUserInfo();
    if (currentUserInfo.getId() == null) {
      throw new GlobalExceptionHandler.ForbiddenException();
    }
    Card card = cardRepository.findByIdAndUserId(cardId, id)
        .orElseThrow(() -> new NotFoundException());

    card.setNumber(cardDTO.number());
    card.setHolderName(cardDTO.holderName());
    card.setCpf(cardDTO.cpf());
    card.setValidity(cardDTO.validity());
    card.setCvv(cardDTO.cvv());

    utilityService.associateUser(card::setUser, cardDTO.userId());

    card = cardRepository.save(card);
    return convertToDTO(card);
  }

  @Transactional
  public void deleteCard(String token, Long cardId) {
    Long id = jwtTokenProvider.extractUserId(token);
    UserInfo currentUserInfo = authService.getCurrentUserInfo();
    if (currentUserInfo.getId() == null) {
      throw new GlobalExceptionHandler.ForbiddenException();
    }
    if (!cardRepository.existsById(cardId)) {
      throw new NotFoundException();
    }
    cardRepository.deleteById(cardId);
  }

  private CardDTO convertToDTO(Card card) {
    return new CardDTO(
        card.getCardId(),
        card.getNumber(),
        card.getHolderName(),
        card.getCpf(),
        card.getValidity(),
        card.getCvv(),
        card.getUser().getUserId()
    );
  }

  private Card convertToEntity(CardDTO cardDTO) {
    Card card = new Card();
    card.setCardId(cardDTO.cardId());
    card.setNumber(cardDTO.number());
    card.setHolderName(cardDTO.holderName());
    card.setCpf(cardDTO.cpf());
    card.setValidity(cardDTO.validity());
    card.setCvv(cardDTO.cvv());
    utilityService.associateUser(card::setUser, cardDTO.userId());
    return card;
  }
}