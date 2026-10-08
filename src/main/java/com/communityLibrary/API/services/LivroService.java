package com.communityLibrary.API.services;

import com.communityLibrary.API.entity.Livro;
import com.communityLibrary.API.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro>  buscarLivros() {
        return livroRepository.findAll();
    }

    public Livro buscarLivro(Long id) {
        return livroRepository.findById(id).orElse(null);
    }

    public Livro salvarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
