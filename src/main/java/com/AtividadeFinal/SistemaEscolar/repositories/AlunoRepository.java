package com.AtividadeFinal.SistemaEscolar.repositories;

import com.AtividadeFinal.SistemaEscolar.Models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
