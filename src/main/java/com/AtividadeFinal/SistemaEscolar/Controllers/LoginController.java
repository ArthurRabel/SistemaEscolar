package com.AtividadeFinal.SistemaEscolar.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @PostMapping("/main")
    public String selectAluno(){
        return "redirect:/main";
    }
}
