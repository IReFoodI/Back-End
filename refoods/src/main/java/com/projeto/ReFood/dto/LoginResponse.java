package com.projeto.ReFood.dto;

public record LoginResponse(String jwt, Long id, String nome, String email, String message) {
  public LoginResponse(String jwt, Long id, String nome, String email) {
      this(jwt, id, nome, email, null);
  }

  public LoginResponse(String message) {
      this(null, null, null, null, message);
  }
}
