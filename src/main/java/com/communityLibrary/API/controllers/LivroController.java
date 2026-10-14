package com.communityLibrary.API.controllers;

import com.communityLibrary.API.dtos.LeitorResponseDTO;
import com.communityLibrary.API.dtos.LivroRequestDTO;
import com.communityLibrary.API.dtos.LivroResponseDTO;
import com.communityLibrary.API.entity.Livro;
import com.communityLibrary.API.services.LivroService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroResponseDTO>> listarLivros() {
        List<LivroResponseDTO> livros = livroService.buscarLivros();
        return ResponseEntity.ok(livros);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> buscarLivro(@PathVariable Long id){
        LivroResponseDTO livro = livroService.buscarLivro(id);
        return ResponseEntity.ok(livro);
    }
    @PostMapping
    public ResponseEntity<LivroResponseDTO> salvarLivro(@Valid @RequestBody LivroRequestDTO dadosLivro){
        LivroResponseDTO livroSalvo = livroService.salvarLivro(dadosLivro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id){
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }

}
