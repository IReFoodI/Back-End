package com.projeto.ReFood.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping({ "/", "" })
  public String redirectToSwagger() {
    return "redirect:/swagger-ui/index.html";
  }

  @PreAuthorize("hasAnyRole('ROLE_USER')")
  @GetMapping("/user")
  public ResponseEntity<String> isUser() {
    return ResponseEntity.ok("Você tem acesso de usuário.");
  }

  @PreAuthorize("hasAnyRole('ROLE_RESTAURANT')")
  @GetMapping("/restaurant")
  public ResponseEntity<String> isRestaurant() {
    return ResponseEntity.ok("Você tem acesso de restaurante.");
  }

}
