package com.projeto.ReFood.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NotificationDTO(
    Long notificationId,

    @NotBlank(message = "A mensagem da notificação não pode estar vazia.") String msgNotification,

    boolean msgRead,

    @NotNull(message = "A data de envio não pode ser nula.") LocalDateTime sendDate,

    @NotNull(message = "O ID do usuário não pode ser nulo.") Long userId,

    @NotNull(message = "O ID do restaurante não pode ser nulo.") Long restaurantId) {
}
