package com.communityLibrary.API.dtos;

public record LivroResponseDTO(
    Integer id,
    String titulo,
    String ISBN,
    int anoDePublicacao,
    int quantidadeDisponivel
) {}
