package com.communityLibrary.API.entity;

import jakarta.persistence.*;

@Entity
public class leitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
}