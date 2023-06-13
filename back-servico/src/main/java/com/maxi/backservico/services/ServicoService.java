package com.maxi.backservico.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.backservico.domains.Cliente;
import com.maxi.backservico.domains.Servico;
import com.maxi.backservico.domains.Tecnico;
import com.maxi.backservico.dtos.ServicoDTO;
import com.maxi.backservico.enums.StatusServico;
import com.maxi.backservico.repositories.ServicoRepository;
import com.maxi.backservico.services.exceptions.ObjectNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private TecnicoService tecnicoService;

    @Autowired
    private ClienteService clienteService;

    public Servico findById(Long id) {
        Optional<Servico> obj = servicoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Não foi possivel encontrar o " + Servico.class.getSimpleName() + " com o ID: [" + id + "] informado"));
    }

    public List<Servico> findAll() {
        List<Servico> lista = servicoRepository.findAll();
        return lista;
    }

    public Servico create(ServicoDTO obj) {

        Tecnico tecnico = tecnicoService.findById(obj.getTecnico().getId());
        Cliente cliente = clienteService.findById(obj.getCliente().getId());

        Servico servico = new Servico();
        servico.setCliente(cliente);
        servico.setTecnico(tecnico);
        servico.setDescricao(obj.getDescricao());
        servico.setCusto(obj.getCusto());
        servico.setPrioridade(obj.getPrioridade());
        servico.setStatus(obj.getStatus());

        return servicoRepository.save(servico);
    }

    public boolean cancelarServico(Long id) {
        Servico obj = findById(id);
        if (obj.getStatus().equals(StatusServico.FINALIZADO) || obj.getStatus().equals(StatusServico.CANCELADO)
                || obj.getStatus().equals(StatusServico.ANDAMENTO)) {
            return false;
        } else {
            obj.setStatus(StatusServico.CANCELADO);
            obj.setDatafinalizar(LocalDateTime.now());
            return true;
        }
    }

    public boolean finalizarServico(Long id) {
        Servico obj = findById(id);
        if (obj.getStatus().equals(StatusServico.ANDAMENTO)) {
            obj.setStatus(StatusServico.FINALIZADO);
            obj.setDatafinalizar(LocalDateTime.now());
            return true;
        } else {
            return false;
        }
    }
}
