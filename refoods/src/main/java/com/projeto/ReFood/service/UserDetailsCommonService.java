package com.projeto.ReFood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.projeto.ReFood.exception.GlobalExceptionHandler.NotFoundException;
import com.projeto.ReFood.model.Restaurant;
import com.projeto.ReFood.model.User;
import com.projeto.ReFood.repository.RestaurantRepository;
import com.projeto.ReFood.repository.UserRepository;
import com.projeto.ReFood.security.UserDetailsCommon;

public class UserDetailsCommonService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RestaurantRepository restaurantRepository;

  public UserDetailsCommon getCurrentUser() {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (principal instanceof UserDetails) {
      String email = ((UserDetails) principal).getUsername();

      User user = userRepository.findByEmail(email).orElse(null);
      if (user != null) {
        return user;
      }

      Restaurant restaurant = restaurantRepository.findByEmail(email).orElse(null);
      if (restaurant != null) {
        return restaurant;
      }
    };

    throw new NotFoundException(); 
  }
}
