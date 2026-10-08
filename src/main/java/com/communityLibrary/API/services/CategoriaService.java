package com.communityLibrary.API.services;

import com.communityLibrary.API.entity.Categoria;
import com.communityLibrary.API.entity.Leitor;
import com.communityLibrary.API.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> ListarCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria salvarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria buscarCategoria(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public void deletarCategoria(long id) {
        categoriaRepository.deleteById(id);
    }
}
