package com.projeto.ReFood.dto;

import jakarta.validation.constraints.NotNull;

public record OrderItemDTO(
    Long itemId,

    @NotNull(message = "A quantidade não pode ser nula.") int amount,

    @NotNull(message = "O valor unitário não pode ser nulo.") float unitValue,

    @NotNull(message = "O subtotal não pode ser nulo.") float subtotal,

    @NotNull(message = "O ID do pedido não pode ser nulo.") Long orderId,

    @NotNull(message = "O ID do produto não pode ser nulo.") Long productId) {
}