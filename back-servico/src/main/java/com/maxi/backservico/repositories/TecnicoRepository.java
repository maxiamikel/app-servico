package com.maxi.backservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.backservico.domains.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {

    //@Query(nativeQuery = true, value ="SELECT cpf FROM Tecnicos  WHERE cpf =cpf")
    //Tecnico findByCpf(String cpf);
    
}
