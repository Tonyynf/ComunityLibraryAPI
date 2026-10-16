package com.communityLibrary.API.dtos;

import com.communityLibrary.API.entity.StatusEmprestimo;

import java.time.LocalDate;

public record EmprestimoResponseDTO(
        Long id,
        String nomeLeitor,
        String tituloLivro,
        LocalDate dataEmprestimo,
        LocalDate dataDevolucaoPrevista,
        StatusEmprestimo status
) {}
