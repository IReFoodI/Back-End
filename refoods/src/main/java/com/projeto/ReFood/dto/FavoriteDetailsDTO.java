package com.projeto.ReFood.dto;

public record FavoriteDetailsDTO(
    Long favoriteId,

    Long userId,

    HourDTO hourDTO,

    RestaurantInfoDTO restaurant) {}