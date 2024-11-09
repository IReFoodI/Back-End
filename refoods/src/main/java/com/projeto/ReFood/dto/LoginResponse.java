package com.projeto.ReFood.dto;

public record LoginResponse(String jwt, Long id, String name, String email) {}
