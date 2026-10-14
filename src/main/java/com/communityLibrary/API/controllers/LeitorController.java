package com.communityLibrary.API.controllers;

import com.communityLibrary.API.dtos.LeitorRequestDTO;
import com.communityLibrary.API.dtos.LeitorResponseDTO;
import com.communityLibrary.API.entity.Leitor;
import com.communityLibrary.API.services.LeitorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leitores")
public class LeitorController {

    @Autowired
    private LeitorService leitorService;

    @GetMapping
    public ResponseEntity<List<LeitorResponseDTO>> buscarLeitores()  {
        List<LeitorResponseDTO> leitores = leitorService.buscarLeitores();
        return ResponseEntity.ok(leitores);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LeitorResponseDTO> buscarLeitor(@PathVariable Long id) {
        LeitorResponseDTO leitor = leitorService.buscarLeitor(id);
        return ResponseEntity.ok(leitor);
    }
    @PostMapping
    public ResponseEntity<LeitorResponseDTO> salvarLeitor(@Valid @RequestBody LeitorRequestDTO dadosLeitor) {
        LeitorResponseDTO leitorSalvo = leitorService.salvarLeitor(dadosLeitor);
        return ResponseEntity.status(HttpStatus.CREATED).body(leitorSalvo);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLeitor(@PathVariable Long id) {
        leitorService.deletarLeitor(id);
        return ResponseEntity.noContent().build();
    }
}
