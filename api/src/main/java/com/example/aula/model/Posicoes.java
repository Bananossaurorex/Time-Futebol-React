package com.example.aula.model;

public enum Posicoes {
    GOLEIRO("Goleiro"),
    ZAQUEIRO("Zaqueiro"),
    LATERAL("Lateral"),
    VOLANTE("Volante"),
    ARMADOR("Armador"),
    MEIOCAMPISTA("MeioCampista"),
    PONTA("Ponta"),
    CENTROAVANTE("CentroAvante");

    private final String texto2;

    Posicoes(String texto2) {
        this.texto2 = texto2;
    }

    public String getTexto() {
        return texto2;
    }
    public static Posicoes fromTexto(String texto2) {
        for (Posicoes p : Posicoes.values()) {
            if (p.getTexto().equalsIgnoreCase(texto2)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Sexo inválido: " + texto2);
    }
    
}
