package com.projeto.ReFood.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record RestaurantDTO(
    Long restaurantId,

    @NotBlank(message = "CNPJ não pode estar vazio.") String cnpj,

    @NotBlank(message = "Nome fantasia não pode estar vazio.") String fantasy,

    @NotBlank(message = "Email não pode estar vazio.") String email,

    @NotBlank(message = "Senha não pode estar vazia.") String password,

    String urlBanner,
    String urlLogo,
    int quantityEvaluations,
    int totalEvaluations,
    float averageRating,
    LocalDateTime dateCreation,
    LocalDateTime lastLogin) {
}
