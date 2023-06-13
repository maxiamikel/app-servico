package com.maxi.backservico.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maxi.backservico.enums.Genero;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa implements Serializable{

    private static final long serialVersionUID =1L;

    @JsonIgnore
    @OneToMany(mappedBy = "tecnico")
    private List<Servico> servicos = new ArrayList<>();

    public Cliente() {
        super();
    }

    public Cliente(Long id, String nome, String cpf, String email, Genero genero) {
        super(id, nome, cpf, email, genero);
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    

}
