package com.communityLibrary.API.services;

import com.communityLibrary.API.dtos.LeitorRequestDTO;
import com.communityLibrary.API.dtos.LeitorResponseDTO;
import com.communityLibrary.API.entity.Leitor;
import com.communityLibrary.API.repositories.LeitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeitorService {

    @Autowired
    private LeitorRepository leitorRepository;

    public List<LeitorResponseDTO> buscarLeitores() {
        List<Leitor> leitores = leitorRepository.findAll();

        return leitores.stream()
                .map(Leitor -> new LeitorResponseDTO(Leitor.getId(), Leitor.getNome()))
                .toList();
    }

    public LeitorResponseDTO buscarLeitor(Long id) {
        Leitor leitor = leitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leitor não encontrado"));

        return new LeitorResponseDTO(leitor.getId(), leitor.getNome());
    }

    public LeitorResponseDTO salvarLeitor(LeitorRequestDTO dadosLeitor) {
        Leitor leitor = new Leitor();
        leitor.setNome(dadosLeitor.nome());

        Leitor leitorSalvo = leitorRepository.save(leitor);

        return new LeitorResponseDTO(leitorSalvo.getId(), leitorSalvo.getNome());
    }

    public void deletarLeitor(Long id) {
        if (leitorRepository.existsById(id)) {
            throw new RuntimeException("Leitor não foi encontrado!");
        }
        leitorRepository.deleteById(id);
    }
}
