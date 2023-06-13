package com.maxi.backservico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.backservico.domains.Cliente;
import com.maxi.backservico.domains.Pessoa;
import com.maxi.backservico.dtos.ClienteDTO;
import com.maxi.backservico.repositories.ClienteRepository;
import com.maxi.backservico.repositories.PessoaRepository;
import com.maxi.backservico.services.exceptions.CpfConflictException;
import com.maxi.backservico.services.exceptions.DataIntegrityViolationException;
import com.maxi.backservico.services.exceptions.ObjectNotFoundException;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Cliente findById(Long id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException("Não foi possível localizar o cadastro relacionado ao ID [" + id
                        + "] do " + Cliente.class.getSimpleName().toUpperCase() + " informado"));
    }

    public List<Cliente> findAll() {
        List<Cliente> lista = clienteRepository.findAll();
        return lista;
    }

    public Cliente create(ClienteDTO obj) {
        if (findByCpf(obj.getCpf()) != null) {
            throw new CpfConflictException("O CPF [" + obj.getCpf() + "] informado já está cadastrado no sistama");
        } else {

            Cliente cliente = new Cliente(null, obj.getNome(), obj.getCpf(), obj.getEmail(), obj.getGenero());
            return clienteRepository.save(cliente);
        }
    }

    public Cliente update(Long id, @Valid ClienteDTO obj) {
        Cliente cliente = findById(id);
        if (findByCpf(obj.getCpf()) != null && findByCpf(obj.getCpf()).getId() != id) {
            throw new DataIntegrityViolationException(
                    "O CPF [" + obj.getCpf() + "] informado não pertence ao registro seu.");
        }
        cliente.setEmail(obj.getEmail());
        cliente.setNome(obj.getNome());
        cliente.setGenero(obj.getGenero());
        return clienteRepository.saveAndFlush(cliente);
    }

    public void delete(Long id) {
        Cliente obj = findById(id);
        if (obj.getServicos().size() > 0) {
            throw new DataIntegrityViolationException("Não é possivel completar essa ação, pois o/a "
                    + Cliente.class.getSimpleName() + " tem ["+obj.getServicos().size()+"] serviços em aberto.");
        } else {
            clienteRepository.deleteById(obj.getId());
        }

    }

    private Pessoa findByCpf(String cpf) {
        Pessoa obj = pessoaRepository.findByCpf(cpf);
        if (obj != null) {
            return obj;
        } else {
            return null;
        }
    }

}
