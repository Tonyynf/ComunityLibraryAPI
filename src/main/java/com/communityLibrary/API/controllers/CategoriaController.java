package com.communityLibrary.API.controllers;

import com.communityLibrary.API.dtos.CategoriaRequestDTO;
import com.communityLibrary.API.dtos.CategoriaResponseDTO;
import com.communityLibrary.API.entity.Categoria;
import com.communityLibrary.API.services.CategoriaService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> listarCategorias() {
        List<CategoriaResponseDTO> categorias = categoriaService.listarCategorias();
        return ResponseEntity.ok(categorias);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> buscarCategoria(@PathVariable Long id) {
        CategoriaResponseDTO categoria = categoriaService.buscarCategoria(id);
        return ResponseEntity.ok(categoria);
    }
    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> salvarCategoria(@Valid @RequestBody CategoriaRequestDTO dadosCategoria) {
        CategoriaResponseDTO categoriaSalva = categoriaService.salvarCategoria(dadosCategoria);
        return ResponseEntity.ok(categoriaSalva);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
