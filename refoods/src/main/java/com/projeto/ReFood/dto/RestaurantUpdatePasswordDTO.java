package com.projeto.ReFood.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RestaurantUpdatePasswordDTO(

    @NotBlank(message = "Senha não pode estar vazia.")
    @Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres.")
    String oldPassword,

    @NotBlank(message = "Senha não pode estar vazia.")
    @Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres.")
    String password,

    @NotBlank(message = "Senha não pode estar vazia.")
    @Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres.")
    String confirmPassword

) {
  public RestaurantUpdatePasswordDTO {
    if (!password.equals(confirmPassword)) {
      throw new IllegalArgumentException("A senha e a confirmação devem ser iguais.");
    }
  }
}
