package com.maxi.backservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.backservico.domains.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    //Cliente findByCpf(String cpf);
}
