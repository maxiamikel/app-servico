package com.maxi.backservico.enums;

public enum StatusServico {

    ABERTO("Aberto"),
    ANDAMENTO("Andamento"),
    FINALIZADO("Finalizado"),
    CANCELADO("Cancelado");

    private String status;

    private StatusServico(String status){
        this.status = status;
    }
    
    public String getStatus() {
        return status;
    }
}
