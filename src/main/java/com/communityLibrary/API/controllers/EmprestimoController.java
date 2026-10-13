package com.communityLibrary.API.controllers;

import com.communityLibrary.API.entity.Emprestimo;
import com.communityLibrary.API.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public List<Emprestimo> buscarEmprestimos() {
        return emprestimoService.listarEmprestimos();
    }
    @GetMapping("/{id}")
    public Emprestimo buscarEmprestimo(@PathVariable Long id) {
        return emprestimoService.buscarEmprestimo(id);
    }
    @PostMapping
    public Emprestimo salvarEmprestimo(@RequestBody Emprestimo emprestimo){
        return emprestimoService.salvarEmprestimo(emprestimo);
    }
    @DeleteMapping("/{id}")
    public void deletarEmprestimo(@PathVariable Long id){
        emprestimoService.deletarEmprestimo(id);
    }


}
