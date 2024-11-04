package com.projeto.ReFood.dto;

import jakarta.validation.constraints.*;

public record RestaurantUpdateEmailDTO(

    @NotBlank(message = "Email não pode estar vazio.")
    @Email(message = "Email deve ser válido.")
    @Size(max = 100, message = "Email deve ter no máximo 100 caracteres.")
    String oldEmail,

    @NotBlank(message = "Email não pode estar vazio.")
    @Email(message = "Email deve ser válido.")
    @Size(max = 100, message = "Email deve ter no máximo 100 caracteres.")
    String email,

    @NotBlank(message = "Email não pode estar vazio.")
    @Email(message = "Email deve ser válido.")
    @Size(max = 100, message = "Email deve ter no máximo 100 caracteres.")
    String confirmEmail

) {
  public RestaurantUpdateEmailDTO {
    if (!email.equals(confirmEmail)) {
      throw new IllegalArgumentException("O email e a confirmação devem ser iguais.");
    }
  }
}
