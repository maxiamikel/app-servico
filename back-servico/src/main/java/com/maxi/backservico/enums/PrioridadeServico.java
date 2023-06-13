package com.maxi.backservico.enums;

public enum PrioridadeServico {
    ALTA("Alta"),
    NORMAL("Normal"),
    BAIXA("Baixa");

    private String prioridade;

    private PrioridadeServico(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getPrioridade() {
        return prioridade;
    }

}
