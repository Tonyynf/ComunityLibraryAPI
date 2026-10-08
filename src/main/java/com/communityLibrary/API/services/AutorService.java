package com.communityLibrary.API.services;

import com.communityLibrary.API.entity.Autor;
import com.communityLibrary.API.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public Autor salvarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor getById(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        autorRepository.deleteById(id);
    }
}
