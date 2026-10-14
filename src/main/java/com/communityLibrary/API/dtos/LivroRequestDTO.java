package com.communityLibrary.API.dtos;

import jakarta.validation.constraints.*;

public record LivroRequestDTO(
        @NotBlank(message= "O nome é obrigatório")
        String titulo,

        @NotBlank(message= "O nome é obrigatório")
        String ISBN,

        @NotNull(message = "O livro precisa do ano de publicação")
        int anoDePublicacao,

        @NotNull(message = "A quantidade é obrigatória")
        int quantidadeDisponivel
) {}
