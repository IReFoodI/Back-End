package com.projeto.ReFood.service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.projeto.ReFood.exception.NotFoundException;
import com.projeto.ReFood.model.Card;
import com.projeto.ReFood.model.Restaurant;
import com.projeto.ReFood.model.Transaction;
import com.projeto.ReFood.model.User;
import com.projeto.ReFood.repository.RestaurantRepository;
import com.projeto.ReFood.repository.TransactionRepository;
import com.projeto.ReFood.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UtilityService {

  private final UserRepository userRepository;
  private final RestaurantRepository restaurantRepository;
  private final TransactionRepository transactionRepository;

  public boolean isEmailUnique(String email) {
    return !userRepository.existsByEmail(email) && !restaurantRepository.existsByEmail(email);
  }

  public void associateUser(Consumer<User> userSetter, Long userId) {
    if (userId != null) {
      User user = userRepository.findById(userId)
          .orElseThrow(() -> new NotFoundException("User not found with ID: " + userId));
      userSetter.accept(user);
    } else {
      throw new IllegalArgumentException("User ID cannot be null when creating a card.");
    }
  }

  public void associateRestaurant(Consumer<Restaurant> restaurantSetter, Long restaurantId) {
    Restaurant restaurant = restaurantRepository.findById(restaurantId)
        .orElseThrow(() -> new NotFoundException("Restaurante não encontrado com ID: " + restaurantId));
    restaurantSetter.accept(restaurant);
  }

  public void associateTransactions(Card card, Set<Long> transactionIds) {
    if (transactionIds != null && !transactionIds.isEmpty()) {
      Set<Transaction> transactions = transactionIds.stream()
          .map(transactionId -> transactionRepository.findById(transactionId)
              .orElseThrow(() -> new NotFoundException("Transaction not found with ID: " + transactionId)))
          .collect(Collectors.toSet());
      card.setCardTransactions(transactions);
    }
  }
}
