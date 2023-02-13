package com.login.sistema.Controllers;

import com.login.sistema.Models.Aluno;
import com.login.sistema.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class alunoController {

    Aluno alunoGlobal = new Aluno();
    @Autowired
    private AlunoRepository Repository;

    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @PostMapping("/index/login")
    public String loginAluno(Aluno aluno){
        System.out.println("_____________________________________________________________________");
        System.out.println(aluno);
        System.out.println("_____________________________________________________________________");
        Optional<Aluno> alunoDBD = this.Repository.findById(aluno.getId());
        System.out.println("_____________________________________________________________________");
        System.out.println(alunoDBD);
        System.out.println("_____________________________________________________________________");
        if(alunoDBD.get().getSenha().equals(aluno.getSenha())){
            alunoGlobal.setId(aluno.getId());;
            System.out.println("_____________________________________________________________________");
            System.out.println("foi pro home");
            System.out.println("_____________________________________________________________________");
            return "redirect:/home";
        }else{
            return "redirect:/index";
        }
    }
    @GetMapping("/inscricao")
    public String inscricao(){
        return "inscricao";
    }
    @PostMapping("/inscricao/new")
    public String createAluno(Aluno aluno){
        //Set no banco de dados
        this.Repository.save(aluno);
        //Set na variavel global
        alunoGlobal.setId(aluno.getId());
        return "redirect:/home";
    }
    @GetMapping("/home")
    public ModelAndView home(){
        //Get do banco de dados pelo ID da variavel global
        Optional<Aluno> aluno = this.Repository.findById(alunoGlobal.getId());

        ModelAndView mv = new ModelAndView("/home");
        mv.addObject("aluno",aluno);
        return mv;
    }
}
