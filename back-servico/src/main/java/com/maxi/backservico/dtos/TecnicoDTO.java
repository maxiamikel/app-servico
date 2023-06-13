package com.maxi.backservico.dtos;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.br.CPF;

import com.maxi.backservico.domains.Tecnico;
import com.maxi.backservico.enums.Genero;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class TecnicoDTO {

    private Long id;

    @NotEmpty(message = "O nome é requerido.")
    @Size(min = 3, message = "Informe um nome válido (min size = 3)")
    private String nome;

    @CPF(message = "Informe um CPF válido")
    private String cpf;

    @NotEmpty(message = "O email é requerido")
    @Email(message = "Informe um email válido")
    private String email;
    
    private Genero genero;
    private String matricula;
    private LocalDateTime dataAdmicao;
    private double salario;

    public TecnicoDTO() {
    }

    public TecnicoDTO(Tecnico obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.genero = obj.getGenero();
        this.matricula = obj.getMatricula();
        this.dataAdmicao = obj.getDataAdmicao();
    }

   

    public TecnicoDTO(Long id, String nome, String cpf, String email, Genero genero, String matricula,
            LocalDateTime dataAdmicao, double salario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.genero = genero;
        this.matricula = matricula;
        this.dataAdmicao = dataAdmicao;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDateTime getDataAdmicao() {
        return dataAdmicao;
    }

    public void setDataAdmicao(LocalDateTime dataAdmicao) {
        this.dataAdmicao = dataAdmicao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    

}
