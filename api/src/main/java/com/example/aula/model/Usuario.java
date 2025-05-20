package com.example.aula.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tab_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @NotBlank(message = "Idade é obrigatorio.")
    private String idade;

    @NotBlank(message = "Altura é obrigatorio.")
    private String altura;

    @NotBlank(message = "Peso é obrigatorio.")
    private String peso;

    @Enumerated(EnumType.STRING)
    private Posicoes posicao;

    @NotBlank(message = "Número da camisa é obrigatorio.")
    private String numCamisa;

    public Usuario() {
    }

    public Usuario(Long id, @NotBlank(message = "Nome é obrigatório.") String nome, Sexo sexo,
            @NotBlank(message = "Idade é obrigatorio.") String idade,
            @NotBlank(message = "Altura é obrigatorio.") String altura,
            @NotBlank(message = "Peso é obrigatorio.") String peso, Posicoes posicao,
            @NotBlank(message = "Número da camisa é obrigatorio.") String numCamisa) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.posicao = posicao;
        this.numCamisa = numCamisa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo.getTexto();
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPosicao() {
        return posicao.getTexto();
    }

    public void setPosicao(Posicoes posicao) {
        this.posicao = posicao;
    }

    public String getNumCamisa() {
        return numCamisa;
    }

    public void setNumCamisa(String numCamisa) {
        this.numCamisa = numCamisa;
    }
    
    
}
