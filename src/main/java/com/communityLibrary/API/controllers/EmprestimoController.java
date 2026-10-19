package com.communityLibrary.API.controllers;

import com.communityLibrary.API.dtos.EmprestimoRequestDTO;
import com.communityLibrary.API.dtos.EmprestimoResponseDTO;
import com.communityLibrary.API.dtos.LeitorResponseDTO;
import com.communityLibrary.API.services.EmprestimoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public ResponseEntity<List<EmprestimoResponseDTO>> listarEmprestimos() {
        List<EmprestimoResponseDTO> emprestimos = emprestimoService.listarEmprestimos();
        return ResponseEntity.ok(emprestimos);
    }

    @PostMapping
    public ResponseEntity<EmprestimoResponseDTO> realizarEmprestimo(@Valid @RequestBody EmprestimoRequestDTO dadosEmprestimo) {
        EmprestimoResponseDTO emprestimoSalvo = emprestimoService.realizarEmprestimo(dadosEmprestimo);

        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoSalvo);
    }
    @PutMapping("/{id}/devolucao")
    public ResponseEntity<EmprestimoResponseDTO> registrarDevolucao(@PathVariable Long id) {
        EmprestimoResponseDTO response = emprestimoService.registrarDevolucao(id);
        return ResponseEntity.ok(response);
    }
}
