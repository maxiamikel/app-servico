package com.maxi.backservico.dtos;

import java.time.LocalDateTime;

import com.maxi.backservico.domains.Cliente;
import com.maxi.backservico.domains.Servico;
import com.maxi.backservico.domains.Tecnico;
import com.maxi.backservico.enums.PrioridadeServico;
import com.maxi.backservico.enums.StatusServico;

public class ServicoDTO {

    private Long id;

    private String descricao;

    private LocalDateTime dataPedido;

    private LocalDateTime dataFinalizar;

    private double custo;

    private StatusServico status;

    private PrioridadeServico prioridade;

    private Tecnico tecnico;

    private Cliente cliente;

    public ServicoDTO() {
    }

    public ServicoDTO(Servico obj) {
        this.id = obj.getId();
        this.descricao = obj.getDescricao();
        this.dataPedido = obj.getDataPedido();
        this.dataFinalizar = obj.getDatafinalizar();
        this.custo = obj.getCusto();
        this.status = obj.getStatus();
        this.prioridade = obj.getPrioridade();
        this.cliente = obj.getCliente();
        this.tecnico = obj.getTecnico();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public LocalDateTime getDataFinalizar() {
        return dataFinalizar;
    }

    public void setDataFinalizar(LocalDateTime dataFinalizar) {
        this.dataFinalizar = dataFinalizar;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public StatusServico getStatus() {
        return status;
    }

    public void setStatus(StatusServico status) {
        this.status = status;
    }

    public PrioridadeServico getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(PrioridadeServico prioridade) {
        this.prioridade = prioridade;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    

}
