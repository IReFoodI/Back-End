package com.projeto.ReFood.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.projeto.ReFood.exception.NotFoundException;
import com.projeto.ReFood.model.Card;
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

  public void associateUser(Card card, Long userId) {
        if (userId != null) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new NotFoundException("User not found with ID: " + userId));
            card.setUser(user);
        } else {
            throw new IllegalArgumentException("User ID cannot be null when creating a card.");
        }
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
