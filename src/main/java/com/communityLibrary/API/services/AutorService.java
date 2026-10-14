package com.communityLibrary.API.services;

import com.communityLibrary.API.dtos.AutorRequestDTO;
import com.communityLibrary.API.dtos.AutorResponseDTO;
import com.communityLibrary.API.entity.Autor;
import com.communityLibrary.API.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<AutorResponseDTO> listarTodos() {
        List<Autor> autores = autorRepository.findAll();
        return autores.stream()
                .map(autor -> new AutorResponseDTO(autor.getId(), autor.getNome()))
                .toList();
    }

    public AutorResponseDTO salvarAutor(AutorRequestDTO dadosAutor) {
        Autor autor = new Autor();
        autor.setNome(dadosAutor.nome());

        Autor autorSalvo = autorRepository.save(autor);

        return new AutorResponseDTO(autorSalvo.getId(), autorSalvo.getNome());
    }

    public AutorResponseDTO buscarAutor(Long id) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não foi encontrado!"));

        return new AutorResponseDTO(autor.getId(), autor.getNome());
    }

    public void deletarAutor(Long id) {
        if (autorRepository.existsById(id)) {
            throw new RuntimeException("Autor não foi encontrado!");
        }
        autorRepository.deleteById(id);
    }
}
