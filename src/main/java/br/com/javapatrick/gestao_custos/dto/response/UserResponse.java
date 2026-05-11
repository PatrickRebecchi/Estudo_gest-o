package br.com.javapatrick.gestao_custos.dto.response;

public record UserResponse(
        Long id,
        String nome,
        String email
) {
}
