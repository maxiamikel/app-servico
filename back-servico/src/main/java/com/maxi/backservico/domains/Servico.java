package com.maxi.backservico.domains;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maxi.backservico.enums.PrioridadeServico;
import com.maxi.backservico.enums.StatusServico;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicos")
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @JsonFormat(pattern = "dd/mm/yyy HH:mm")
    private LocalDateTime dataPedido;

    @JsonFormat(pattern = "dd/mm/yyy HH:mm")
    private LocalDateTime dataFinalizar;

    private double custo;

    @Enumerated(EnumType.STRING)
    private StatusServico status;

    @Enumerated(EnumType.STRING)
    private PrioridadeServico prioridade;

    @ManyToOne()
    @JoinColumn(name = "tecnico_fk")
    private Tecnico tecnico;

    @ManyToOne()
    @JoinColumn(name = "cliente_fk")
    private Cliente cliente;

    public Servico() {
        super();
        this.setDataPedido(LocalDateTime.now());
        this.setPrioridade(PrioridadeServico.NORMAL);
        this.setStatus(StatusServico.ABERTO);
        this.setDatafinalizar(null);
    }  

    public Servico(Long id, String descricao, LocalDateTime dataPedido, double custo,
            StatusServico status, PrioridadeServico prioridade, Tecnico tecnico, Cliente cliente) {
        this.id = id;
        this.descricao = descricao;
        this.setDataPedido(LocalDateTime.now());
        this.custo = custo;
        this.status = status;
        this.prioridade = prioridade;
        this.tecnico = tecnico;
        this.cliente = cliente;
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

    public LocalDateTime getDatafinalizar() {
        return dataFinalizar;
    }

    public void setDatafinalizar(LocalDateTime datafinalizar) {
        this.dataFinalizar = datafinalizar;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Servico other = (Servico) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
