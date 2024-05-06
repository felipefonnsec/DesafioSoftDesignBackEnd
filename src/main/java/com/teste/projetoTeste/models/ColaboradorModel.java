package com.teste.projetoTeste.models;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "TB_COLABORADOR")
public class ColaboradorModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPauta;
    private String nome;

    public Long getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(Long idPauta) {
        this.idPauta = idPauta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
