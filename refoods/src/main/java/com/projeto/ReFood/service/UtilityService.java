package com.projeto.ReFood.service;

import org.springframework.stereotype.Service;

import com.projeto.ReFood.repository.RestaurantRepository;
import com.projeto.ReFood.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UtilityService {
  
  private final UserRepository userRepository;  
  private final RestaurantRepository restaurantRepository;

  public boolean isEmailUnique(String email) {
    return !userRepository.existsByEmail(email) && !restaurantRepository.existsByEmail(email);
  }
}
