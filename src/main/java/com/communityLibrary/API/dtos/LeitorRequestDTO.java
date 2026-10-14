package com.communityLibrary.API.dtos;

import jakarta.validation.constraints.NotBlank;

public record LeitorRequestDTO(
        @NotBlank(message= "O nome é obrigatório")
        String nome
) {}
