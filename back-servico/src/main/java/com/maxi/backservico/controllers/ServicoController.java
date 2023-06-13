package com.maxi.backservico.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maxi.backservico.domains.Servico;
import com.maxi.backservico.dtos.ServicoDTO;
import com.maxi.backservico.services.ServicoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Servico obj = servicoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> findAll(){
        List<Servico> lista = servicoService.findAll();
        List<ServicoDTO> listaDTO = lista.stream().map(obj -> new ServicoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDTO);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<?> create(@RequestBody ServicoDTO obj){
        Servico servico = servicoService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(servico);
    }

    @PutMapping(value = "/cancel/{id}")
    public ResponseEntity<?> cancel(@PathVariable Long id){
        if(servicoService.cancelarServico(id)){
            return ResponseEntity.ok().body("O servico ID["+id+"] foi cancelado com sucesso");
        }else{
            return ResponseEntity.badRequest().body("Não foi possível completar essa ação");
        }
    }

    @PutMapping(value = "/finalize/{id}")
    public ResponseEntity<?> finalize(@PathVariable Long id){
        if(servicoService.finalizarServico(id)){
            return ResponseEntity.ok().body("O servico ID["+id+"] foi finalizado com sucesso");
        }else{
            return ResponseEntity.badRequest().body("Não foi possível completar essa ação");
        }
    }
    
}
