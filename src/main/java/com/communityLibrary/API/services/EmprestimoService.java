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
        boolean livroJaEmprestado = emprestimoRepository.existsByLivroIdAndStatus(dados.idLivro(), StatusEmprestimo.ATIVO);
        if (livroJaEmprestado) {
            throw new RuntimeException("Este livro já se encontra emprestado no momento!");
        }

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

        Emprestimo emprestimoSalvo = emprestimoRepository.save(emprestimo);

        return new EmprestimoResponseDTO(
                emprestimoSalvo.getId(),
                leitor.getNome(),
                livro.getTitulo(),
                emprestimoSalvo.getDataEmprestimo(),
                emprestimoSalvo.getDataPrevistaDevolucao(),
                emprestimoSalvo.getStatus()
        );
    }

    public EmprestimoResponseDTO registrarDevolucao(Long id) {
        Emprestimo emprestimo = emprestimoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado com o ID: " + id));

        if (emprestimo.getStatus() == StatusEmprestimo.DEVOLVIDO) {
            throw new RuntimeException("Este empréstimo já foi finalizado/devolvido.");
        }

        emprestimo.setDataDevolucao(LocalDate.now());
        emprestimo.setStatus(StatusEmprestimo.DEVOLVIDO);

        Emprestimo emprestimoAtualizado = emprestimoRepository.save(emprestimo);

        return new EmprestimoResponseDTO(
                emprestimoAtualizado.getId(),
                emprestimoAtualizado.getLeitor().getNome(),
                emprestimoAtualizado.getLivro().getTitulo(),
                emprestimoAtualizado.getDataEmprestimo(),
                emprestimoAtualizado.getDataPrevistaDevolucao(),
                emprestimoAtualizado.getStatus()
        );
    }

    public List<EmprestimoResponseDTO> listarEmprestimos() {
        List<Emprestimo> emprestimos = emprestimoRepository.findAll();

        return emprestimos.stream().map(emprestimo -> new EmprestimoResponseDTO(
                emprestimo.getId(),
                emprestimo.getLeitor().getNome(),
                emprestimo.getLivro().getTitulo(),
                emprestimo.getDataEmprestimo(),
                emprestimo.getDataPrevistaDevolucao(),
                emprestimo.getStatus()
        )).toList();
    }
    public void excluirEmprestimo(Long id) {
        if (emprestimoRepository.existsById(id)) {
            throw new RuntimeException("Emprestimo não foi encontrado!");
        }
        emprestimoRepository.deleteById(id);
    }
}
