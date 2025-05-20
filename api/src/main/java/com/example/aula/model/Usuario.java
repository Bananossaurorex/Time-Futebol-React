package com.example.aula.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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

    @NotBlank(message = "Posição é obrigatorio.")
    private String posicao;

    @NotBlank(message = "Número da camisa é obrigatorio.")
    private String numCamisa;

    public Usuario() {
    }

    public Usuario(Long id, String nome, Sexo sexo, String idade, String altura, String peso, String posicao, String numCamisa) {
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

    public @NotBlank(message = "Nome é obrigatório.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatório.") String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo.getTexto();
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public @NotBlank(message = "Idade é obrigatorio.") String getIdade() {
        return idade;
    }

    public void setIdade(@NotBlank(message = "Idade é obrigatorio.") String idade) {
        this.idade = idade;
    }

    public @NotBlank(message = "Altura é obrigatorio.") String getAltura() {
        return altura;
    }

    public void setAltura(@NotBlank(message = "Altura é obrigatorio.") String altura) {
        this.altura = altura;
    }

    public @NotBlank(message = "Peso é obrigatorio.") String getPeso() {
        return peso;
    }

    public void setPeso(@NotBlank(message = "Peso é obrigatorio.") String peso) {
        this.peso = peso;
    }

    public @NotBlank(message = "Posição é obrigatorio.") String getPosicao() {
        return posicao;
    }

    public void setPosicao(@NotBlank(message = "Posição é obrigatorio.") String posicao) {
        this.posicao = posicao;
    }

    public @NotBlank(message = "Número da camisa é obrigatorio.") String getNumCamisa() {
        return numCamisa;
    }

    public void setNumCamisa(@NotBlank(message = "Número da camisa é obrigatorio.") String numCamisa) {
        this.numCamisa = numCamisa;
    }
}
