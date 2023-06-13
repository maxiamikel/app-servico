package com.maxi.backservico.domains;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maxi.backservico.enums.Genero;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Tecnico extends Pessoa implements Serializable{

    private static final long serialVersionUID =1L;

    private String matricula;
    private LocalDateTime dataAdmicao;
    private double salario;

    @JsonIgnore
    @OneToMany(mappedBy = "tecnico")
    private List<Servico> servicos = new ArrayList<>();

    public Tecnico() {
        super();
    }

    public Tecnico(Long id, String nome, String cpf, String email, Genero genero, String matricula,
             double salario) {
        super(id, nome, cpf, email, genero);
        this.setMatricula("TC-"+this.getCpf().substring(0, 3)+this.getCpf().substring(4, 7)+this.getCpf().substring(8, 11)+this.getCpf().substring(11, 14));
        this.setDataAdmicao(LocalDateTime.now());;
        this.salario = salario;
    }

    public Tecnico(String matricula, LocalDateTime dataAdmicao, double salario) {
        this.matricula = matricula;
        this.dataAdmicao = dataAdmicao;
        this.salario = salario;
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

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    

}
