package com.login.sistema.Controllers;

import com.login.sistema.DTO.RequisicaoAluno;
import com.login.sistema.Models.Aluno;
import com.login.sistema.repositories.AlunoRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class alunoController {

    @Autowired
    private AlunoRepository Repository;

    @GetMapping("/index")
    public String index(){

        return "index";

    }
    @PostMapping("/index/login")
    public String loginAluno(Aluno aluno, HttpSession session){

        //Verificar se existe tal matricula
        if(this.Repository.existsById(aluno.getId())){

            //Get no banco de dados usando o ID da sessão
            Optional<Aluno> alunoDBD = this.Repository.findById(aluno.getId());

            //Verificar se as senhas são iguais
            if(alunoDBD.get().getSenha().equals(aluno.getSenha())){

                //Set o ID na sessão
                session.setAttribute("alunoId", aluno.getId());

                return "redirect:/home";

            }else{

                return "redirect:/index";

            }

        } else {

            return "redirect:/index";

        }

    }
    
    @GetMapping("/inscricao")
    public String inscricao(){

        return "inscricao";

    }
    
    @PostMapping("/inscricao/new")
    public String createAluno(@Valid RequisicaoAluno requisicao, BindingResult bindingResult, HttpSession session){

        //Verificar se tem erro nas regras de negocio da classe
        if(bindingResult.hasErrors()){

            return "redirect:/inscricao";

        }else{

            //Set os valores do DTO para a classe
            Aluno aluno = requisicao.toALuno();

            System.out.println(aluno.toString());
            //Set no banco de dados
            this.Repository.save(aluno);

            System.out.println(aluno.toString());

            //Set ID na sessão
            session.setAttribute("alunoId", aluno.getId());
            return "redirect:/home";

        }

    }
    
    @GetMapping("/home")
    public ModelAndView home(HttpSession session){

        //Get id da session
        Long alunoId = ((Integer) session.getAttribute("alunoId")).longValue();

        //Get no banco de dados usando o ID da sessão
        Optional<Aluno> aluno = this.Repository.findById(alunoId.intValue());

        //Set classe aluno dentro da pagina
        ModelAndView mv = new ModelAndView("/home");
        mv.addObject("aluno",aluno);

        return mv;

    }
}
