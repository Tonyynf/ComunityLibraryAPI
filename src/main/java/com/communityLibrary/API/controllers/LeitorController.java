package com.communityLibrary.API.controllers;

import com.communityLibrary.API.entity.Leitor;
import com.communityLibrary.API.services.LeitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leitores")
public class LeitorController {

    @Autowired
    private LeitorService leitorService;

    @GetMapping
    public List<Leitor> buscarLeitores() {
        return leitorService.buscarLeitores();
    }
    @GetMapping("/{id}")
    public Leitor buscarLeitor(@PathVariable Long id) {
        return leitorService.buscarLeitor(id);
    }
    @PostMapping
    public Leitor salvarLeitor(@RequestBody Leitor leitor) {
        return leitorService.salvarLeitor(leitor);
    }
    @DeleteMapping("/{id}")
    public void deletarLeitor(@PathVariable Long id) {
        leitorService.deletarLeitor(id);
    }
}
