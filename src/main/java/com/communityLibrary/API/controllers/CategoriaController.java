package com.communityLibrary.API.controllers;

import com.communityLibrary.API.entity.Categoria;
import com.communityLibrary.API.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaService.ListarCategorias();
    }
    @GetMapping("/{id}")
    public Categoria buscarCategoria(@PathVariable Long id) {
        return categoriaService.buscarCategoria(id);
    }
    @PostMapping
    public Categoria salvarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.salvarCategoria(categoria);
    }
    @DeleteMapping("/{id}")
    public void deletarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoria(id);
    }
}
