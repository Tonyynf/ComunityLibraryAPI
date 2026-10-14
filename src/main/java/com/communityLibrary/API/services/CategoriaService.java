package com.communityLibrary.API.services;

import com.communityLibrary.API.dtos.CategoriaRequestDTO;
import com.communityLibrary.API.dtos.CategoriaResponseDTO;
import com.communityLibrary.API.entity.Categoria;
import com.communityLibrary.API.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaResponseDTO> listarCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream()
                .map(categoria -> new CategoriaResponseDTO(categoria.getId(), categoria.getNome()))
                .toList();
    }

    public CategoriaResponseDTO salvarCategoria(CategoriaRequestDTO dadosCategoria) {
        Categoria categoria = new Categoria();
        categoria.setNome(dadosCategoria.nome());

        categoria = categoriaRepository.save(categoria);

        return new CategoriaResponseDTO(categoria.getId(), categoria.getNome());
    }

    public CategoriaResponseDTO buscarCategoria(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não foi encontrada!"));

        return new CategoriaResponseDTO(categoria.getId(), categoria.getNome());
    }

    public void deletarCategoria(long id) {
        if(!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoria não foi encontrada!");
        }
        categoriaRepository.deleteById(id);
    }
}
