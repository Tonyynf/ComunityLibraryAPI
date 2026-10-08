package com.communityLibrary.API.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_livros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private String ISBN;
    private int anoDePublicacao;
    private int quantidadeDisponivel;
}
