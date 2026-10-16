package com.communityLibrary.API.services;

import com.communityLibrary.API.dtos.EmprestimoRequestDTO;
import com.communityLibrary.API.dtos.EmprestimoResponseDTO;
import com.communityLibrary.API.entity.Emprestimo;
import com.communityLibrary.API.entity.Leitor;
import com.communityLibrary.API.entity.Livro;
import com.communityLibrary.API.entity.StatusEmprestimo;
import com.communityLibrary.API.repositories.EmprestimoRepository;
import com.communityLibrary.API.repositories.LeitorRepository;
import com.communityLibrary.API.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LeitorRepository leitorRepository;

    @Autowired
    private LivroRepository livroRepository;

    public EmprestimoResponseDTO realizarEmprestimo(EmprestimoRequestDTO dados) {
        Leitor leitor = leitorRepository.findById(dados.idLeitor())
                .orElseThrow(() -> new RuntimeException("Leitor não encontrado"));

        Livro livro = livroRepository.findById(dados.idLivro())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLeitor(leitor);
        emprestimo.setLivro(livro);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataPrevistaDevolucao((LocalDate.now().plusDays(14))); // Exemplo: 14 dias de prazo)
        emprestimo.setStatus(StatusEmprestimo.ATIVO);

        // 5. Salva no banco de dados
        Emprestimo emprestimoSalvo = emprestimoRepository.save(emprestimo);

        // 6. Retorna o DTO de Resposta formatado
        return new EmprestimoResponseDTO(
                emprestimoSalvo.getId(),
                leitor.getNome(),
                livro.getTitulo(),
                emprestimoSalvo.getDataEmprestimo(),
                emprestimoSalvo.getDataPrevistaDevolucao(),
                emprestimoSalvo.getStatus()
        );
    }

}
