package com.AtividadeFinal.SistemaEscolar.Controllers;

import com.AtividadeFinal.SistemaEscolar.Models.Aluno;
import com.AtividadeFinal.SistemaEscolar.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class alunoController {

    @Autowired
    private AlunoRepository Repository;

    @GetMapping("/inscricao")
    public String inscricao(){
        return "inscricao";
    }
    @PostMapping("/inscricao/new")
    public String createAluno(Aluno aluno){
        this.Repository.save(aluno);
        return "redirect:/home";
    }

}
