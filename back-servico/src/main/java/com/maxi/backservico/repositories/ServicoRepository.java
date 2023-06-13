package com.maxi.backservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.backservico.domains.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
    
}
