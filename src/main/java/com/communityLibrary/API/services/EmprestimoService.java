package com.communityLibrary.API.services;

import com.communityLibrary.API.entity.Emprestimo;
import com.communityLibrary.API.repositories.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public List<Emprestimo> listarEmprestimos() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo buscarEmprestimo(Long id) {
        return emprestimoRepository.findById(id).orElse(null);
    }

    public Emprestimo salvarEmprestimo(Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    public void deletarEmprestimo(long id) {
        emprestimoRepository.deleteById(id);
    }
}
