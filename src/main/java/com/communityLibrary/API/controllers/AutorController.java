package com.communityLibrary.API.controllers;

import com.communityLibrary.API.dtos.AutorRequestDTO;
import com.communityLibrary.API.dtos.AutorResponseDTO;
import com.communityLibrary.API.entity.Autor;
import com.communityLibrary.API.services.AutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<AutorResponseDTO>> listarAutores(){
        List<AutorResponseDTO> autores = autorService.listarTodos();
        return ResponseEntity.ok(autores);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> buscarAutor(@PathVariable Long id){
        AutorResponseDTO autor = autorService.buscarAutor(id);
        return ResponseEntity.ok(autor);
    }
    @PostMapping
    public ResponseEntity<AutorResponseDTO> salvarAutor(@Valid @RequestBody AutorRequestDTO dadosAutor){
        AutorResponseDTO autorSalvo = autorService.salvarAutor(dadosAutor);

        return ResponseEntity.status(HttpStatus.CREATED).body(autorSalvo);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAutor(@PathVariable Long id){
        autorService.deletarAutor(id);
        return ResponseEntity.noContent().build();
    }
}
