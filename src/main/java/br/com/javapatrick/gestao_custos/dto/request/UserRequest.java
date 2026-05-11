package br.com.javapatrick.gestao_custos.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @NotBlank(message = "Nome obrigatorio")
        String nome,
        @NotBlank(message = "Email obrigatório")
        @Email(message = "Email inválido")
        String email
) {
}
