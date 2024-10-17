package com.projeto.ReFood.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserDTO(
    Long userId,

    @NotBlank(message = "O nome é obrigatório.") String name,

    String surname,

    @NotBlank(message = "O e-mail é obrigatório.") 
    @Email(message = "O e-mail deve ser um endereço de e-mail válido.") String email,

    @NotBlank(message = "O telefone é obrigatório.") 
    @Pattern(regexp = "\\d{10,15}", message = "O telefone deve conter entre 10 e 15 dígitos numéricos.") String phone,

    @NotBlank(message = "A senha é obrigatória.")
    // @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$", 
             // message = "A senha deve ter pelo menos 8 caracteres, incluindo pelo menos uma letra maiúscula, uma letra minúscula e um número.") 
    String password,

    LocalDateTime dateCreation,

    LocalDateTime lastLogin) {
}
