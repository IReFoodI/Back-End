package com.projeto.ReFood.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping({ "/", "" })
  public String redirectToSwagger() {
    return "redirect:/swagger-ui/index.html";
  }

  @GetMapping("/user")
  public ResponseEntity<String> isUser() {
    return ResponseEntity.ok("Você tem acesso de usuário.");
  }

  @GetMapping("/restaurant")
  public ResponseEntity<String> isRestaurant() {
    return ResponseEntity.ok("Você tem acesso de restaurante.");
  }

}
