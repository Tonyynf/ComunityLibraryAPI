package com.communityLibrary.API.services;

import com.communityLibrary.API.entity.Leitor;
import com.communityLibrary.API.repositories.LeitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeitorService {

    @Autowired
    private LeitorRepository LeitorRepository;

    public List<Leitor> buscarCategorias() {
        return LeitorRepository.findAll();
    }

    public Leitor buscarLeitor(Long id) {
        return LeitorRepository.findById(id).orElse(null);
    }

    public Leitor salvarLeitor(Leitor leitor) {
        return LeitorRepository.save(leitor);
    }
    public void deletarLeitor(Long id) {
        LeitorRepository.deleteById(id);
    }
}
