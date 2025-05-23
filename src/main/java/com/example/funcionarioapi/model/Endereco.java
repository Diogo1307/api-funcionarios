package com.example.funcionarioapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A rua é obrigatória")
    @Column(nullable = false)
    private String rua;

    @NotBlank(message = "A cidade é obrigatória")
    @Column(nullable = false)
    private String cidade;

    @NotBlank(message = "O estado é obrigatório")
    @Column(nullable = false)
    private String estado;

    public Endereco() {}
    
    public Endereco(Long id, String rua, String cidade, String estado) {
        this.id = id;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
