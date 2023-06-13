package com.maxi.backservico.enums;

public enum Genero {

    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private String genero;

    private Genero(String genero){
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }
}
