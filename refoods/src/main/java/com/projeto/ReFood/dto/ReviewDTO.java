package com.projeto.ReFood.dto;

import java.util.Date;

import jakarta.validation.constraints.NotNull;

public record ReviewDTO(
    Long reviewId,

    @NotNull(message = "Nota de avaliação não pode ser nula.") int ratingNote,

    @NotNull(message = "Data de avaliação não pode ser nula.") Date ratingDate,

    String ratingComment,

    @NotNull(message = "ID do usuário não pode ser nulo.") Long userId,

    @NotNull(message = "ID do restaurante não pode ser nulo.") Long restaurantId) {
}
