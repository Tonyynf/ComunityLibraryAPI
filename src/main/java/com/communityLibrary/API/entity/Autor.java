package com.communityLibrary.API.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_autores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
}
