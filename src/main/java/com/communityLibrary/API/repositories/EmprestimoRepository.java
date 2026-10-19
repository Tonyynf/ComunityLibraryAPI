package com.communityLibrary.API.repositories;

import com.communityLibrary.API.entity.Emprestimo;
import com.communityLibrary.API.entity.StatusEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    boolean existsByLivroIdAndStatus(Long livroId, StatusEmprestimo status);
}
