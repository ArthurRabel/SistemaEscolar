
package com.login.sistema.DTO;

import com.login.sistema.Models.Aluno;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public class RequisicaoAluno {
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String email;
    @NotNull
    private BigInteger cpf;
    @NotNull
    private BigInteger telefone;
    @NotBlank
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public BigInteger getTelefone() {
        return telefone;
    }

    public void setTelefone(BigInteger telefone) {
        this.telefone = telefone;
    }

    public BigInteger getCpf() {
        return cpf;
    }

    public void setCpf(BigInteger cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Aluno toALuno() {
        Aluno aluno = new Aluno();
        aluno.setNome(this.nome);
        aluno.setSobrenome(this.sobrenome);
        aluno.setEmail(this.email);
        aluno.setCpf(this.cpf);
        aluno.setTelefone(this.telefone);
        aluno.setSenha(this.senha);

        return aluno;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + " " + nome.getClass().getSimpleName() +'\'' +
                ", sobrenome='" + sobrenome + " " + sobrenome.getClass().getSimpleName() + '\'' +
                ", email='" + email + " " + email.getClass().getSimpleName() +'\'' +
                ", cpf='" + cpf + " " + cpf.getClass().getSimpleName() + '\'' +
                ", telefone='" + telefone + " " + telefone.getClass().getSimpleName() + '\'' +
                ", senha='" + senha + " " + senha.getClass().getSimpleName() + '\'' +
                '}';
    }
}
