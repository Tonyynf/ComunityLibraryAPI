package com.communityLibrary.API.dtos;

import jakarta.validation.constraints.NotNull;

public record EmprestimoRequestDTO(
        @NotNull(message = "O ID do leitor é obrigatório")
        Long idLeitor,

        @NotNull(message = "O ID do livro é obrigatório")
        Long idLivro
) {}
