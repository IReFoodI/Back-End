package com.projeto.ReFood.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDTO(
    Long userId,

    @NotBlank(message = "O nome é obrigatório.") String name,

    @NotBlank(message = "O sobrenome é obrigatório.") String surname,

    @NotBlank(message = "O CPF é obrigatório.") String cpf,

    @NotBlank(message = "O e-mail é obrigatório.") String email,

    @NotBlank(message = "O telefone é obrigatório.") String phone,

    @NotBlank(message = "A senha é obrigatória.") String password,

    @NotNull(message = "A data de criação é obrigatória.") LocalDateTime dateCreation,

    LocalDateTime lastLogin) {
}
