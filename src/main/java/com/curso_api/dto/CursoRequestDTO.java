package com.curso_api.dto;

import jakarta.validation.constraints.NotBlank;

public record CursoRequestDTO(
        @NotBlank(message = "Nome do curso é obrigatorio")
        Long instrutorID,
        @NotBlank(message = "Descrição é obrigatoria")
        String nome,
        String descricao,
        Integer cargaHoraria
) {}
