package com.communityLibrary.API.controllers;

import com.communityLibrary.API.entity.Autor;
import com.communityLibrary.API.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<Autor> listarAutores(){
        return autorService.listarTodos();
    }
    @GetMapping("/{id}")
    public Autor buscarAutorPorId(@PathVariable Long id){
        return autorService.buscarAutor(id);
    }
    @PostMapping
    public Autor salvarAutor(@RequestBody Autor autor){
        return autorService.salvarAutor(autor);
    }
    @DeleteMapping("/{id}")
    public void deletarAutor(@PathVariable Long id){
        autorService.deletarAutor(id);
    }
}
