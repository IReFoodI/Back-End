package com.projeto.ReFood.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projeto.ReFood.model.Restaurant;
import com.projeto.ReFood.model.User;
import com.projeto.ReFood.repository.RestaurantRepository;
import com.projeto.ReFood.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;
  private final RestaurantRepository restaurantRepository;

  @Autowired
  public CustomUserDetailsService(UserRepository userRepository, RestaurantRepository restaurantRepository) {
    this.userRepository = userRepository;
    this.restaurantRepository = restaurantRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    System.out.println("==================================================================");
    System.out.println("loadUserByUsername - INICIO");
    User user = userRepository.findByEmail(username).orElse(null);
    if (user != null) {
      System.out.println("loadUserByUsername - USER - FIM");
      System.out.println("==================================================================");
      return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
          List.of(new SimpleGrantedAuthority("ROLE_USER")));
    }

    Restaurant restaurant = restaurantRepository.findByEmail(username).orElse(null);
    if (restaurant != null) {
      System.out.println("loadUserByUsername - RESTAURANT - FIM");
      System.out.println("==================================================================");
      return new org.springframework.security.core.userdetails.User(restaurant.getEmail(), restaurant.getPassword(),
          List.of(new SimpleGrantedAuthority("ROLE_RESTAURANT")));
    }

    throw new UsernameNotFoundException("Usuário não encontrado.");
  }
}
