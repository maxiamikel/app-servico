package com.maxi.backservico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.backservico.domains.Pessoa;
import com.maxi.backservico.domains.Tecnico;
import com.maxi.backservico.dtos.TecnicoDTO;
import com.maxi.backservico.repositories.PessoaRepository;
import com.maxi.backservico.repositories.TecnicoRepository;
import com.maxi.backservico.services.exceptions.CpfConflictException;
import com.maxi.backservico.services.exceptions.DataIntegrityViolationException;
import com.maxi.backservico.services.exceptions.ObjectNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Tecnico findById(Long id) {
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Não foi possivel encontrar o " + Tecnico.class.getSimpleName() + " com o ID: [" + id + "] informado"));
    }

    public List<Tecnico> findAll() {
        List<Tecnico> list = tecnicoRepository.findAll();
        return list;
    }

    public Tecnico create(TecnicoDTO obj) {
        if (findByCpf(obj) == null) {
            Tecnico tecnico = new Tecnico(null, obj.getNome(), obj.getCpf(), obj.getEmail(), obj.getGenero(),
                    obj.getMatricula(), 00);
            return tecnicoRepository.save(tecnico);
        } else {
            throw new CpfConflictException("O CPF [" + obj.getCpf() + " ] informado já está em uso no sistema");
        }
    }

    public Tecnico update(Long id, TecnicoDTO obj) {
        Tecnico tecnico = findById(id);
        if (findByCpf(obj) != null && findByCpf(obj).getId() != id) {
            throw new DataIntegrityViolationException("O CPF informado não pertence ao registro seu");
        }
        tecnico.setNome(obj.getNome());
        tecnico.setSalario(obj.getSalario());
        return tecnicoRepository.saveAndFlush(tecnico);
    }

    public void delete(Long id) {
        Tecnico obj = findById(id);

        if (obj.getServicos().size() > 0) {
            throw new DataIntegrityViolationException("Não é possivel completar essa ação, pois o/a "
                    + Tecnico.class.getSimpleName() + " tem ["+obj.getServicos().size()+"] serviços em aberto.");
        }
        tecnicoRepository.deleteById(obj.getId());
    }

    private Pessoa findByCpf(TecnicoDTO objDTO) {
        Pessoa obj = pessoaRepository.findByCpf(objDTO.getCpf());
        if (obj != null) {
            return obj;
        } else {
            return null;
        }
    }

}