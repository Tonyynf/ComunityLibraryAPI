package com.communityLibrary.API.controllers;

import com.communityLibrary.API.entity.Livro;
import com.communityLibrary.API.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> listarLivros() {
        return livroService.buscarLivros();
    }
    @GetMapping("/{id}")
    public Livro buscarLivro(@PathVariable Long id){
        return livroService.buscarLivro(id);
    }
    @PostMapping
    public Livro salvarLivro(@RequestBody Livro livro){
        return livroService.salvarLivro(livro);
    }
    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id){
        livroService.deletarLivro(id);
    }

}
