package com.maxi.backservico.dtos;

import org.hibernate.validator.constraints.br.CPF;

import com.maxi.backservico.domains.Cliente;
import com.maxi.backservico.enums.Genero;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ClienteDTO {

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

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.genero = obj.getGenero();
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

}
