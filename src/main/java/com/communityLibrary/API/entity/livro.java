package com.communityLibrary.API.entity;

import jakarta.persistence.*;

@Entity
public class livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private String ISBN;
    private int anoDePublicacao;
    private int quantidadeDisponivel;
}
