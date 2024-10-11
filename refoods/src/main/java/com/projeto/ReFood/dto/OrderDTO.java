package com.projeto.ReFood.dto;

import com.projeto.ReFood.model.EnumOrderStatus;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record OrderDTO(
    Long orderId,

    @NotNull(message = "A data do pedido não pode ser nula.")
    Date orderDate,

    @NotNull(message = "O status do pedido não pode ser nulo.")
    EnumOrderStatus orderStatus,

    @NotNull(message = "O valor total não pode ser nulo.")
    float totalValue,

    @NotNull(message = "O ID do usuário não pode ser nulo.")
    Long userId,

    @NotNull(message = "O ID do restaurante não pode ser nulo.")
    Long restaurantId,

    @NotNull(message = "O ID do endereço não pode ser nulo.")
    Long addressId
) {}
