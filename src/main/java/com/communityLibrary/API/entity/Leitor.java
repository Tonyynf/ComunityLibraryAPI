package com.communityLibrary.API.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_leitores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Leitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
}