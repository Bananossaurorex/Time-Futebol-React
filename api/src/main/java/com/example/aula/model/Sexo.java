package com.example.aula.model;

public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private final String texto;


    Sexo(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public static Sexo fromTexto(String texto) {
        for (Sexo s : Sexo.values()) {
            if (s.getTexto().equalsIgnoreCase(texto)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Sexo inválido: " + texto);
    }
}

