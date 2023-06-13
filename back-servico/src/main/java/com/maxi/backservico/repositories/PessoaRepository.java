package com.maxi.backservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.backservico.domains.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

    Pessoa findByCpf(String cpf);
    
}
