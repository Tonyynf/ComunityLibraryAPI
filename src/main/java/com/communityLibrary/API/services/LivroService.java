package com.communityLibrary.API.services;

import com.communityLibrary.API.dtos.LivroRequestDTO;
import com.communityLibrary.API.dtos.LivroResponseDTO;
import com.communityLibrary.API.entity.Livro;
import com.communityLibrary.API.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<LivroResponseDTO>  buscarLivros() {
        List<Livro> livros = livroRepository.findAll();
        return livros.stream()
                .map(livro -> new LivroResponseDTO(livro.getId(), livro.getTitulo(), livro.getISBN(), livro.getAnoDePublicacao(), livro.getAnoDePublicacao()))
                .toList();
    }

    public LivroResponseDTO buscarLivro(Long id) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado!"));

        return new LivroResponseDTO(livro.getId(), livro.getTitulo(), livro.getISBN(), livro.getAnoDePublicacao(), livro.getQuantidadeDisponivel());
    }

    public LivroResponseDTO salvarLivro(LivroRequestDTO dadosLivro) {
        Livro livro = new Livro();
        livro.setTitulo(dadosLivro.titulo());
        livro.setISBN(dadosLivro.ISBN());
        livro.setAnoDePublicacao(dadosLivro.anoDePublicacao());
        livro.setQuantidadeDisponivel(dadosLivro.quantidadeDisponivel());

        Livro livroSalvo = livroRepository.save(livro);

        return new LivroResponseDTO(livroSalvo.getId(), livroSalvo.getTitulo(), livroSalvo.getISBN(), livroSalvo.getAnoDePublicacao(), livroSalvo.getQuantidadeDisponivel());
    }

    public void deletarLivro(Long id) {
        if(!livroRepository.existsById(id)){
            throw new RuntimeException("Livro não foi encontrado!");
        }

        livroRepository.deleteById(id);
    }
}
