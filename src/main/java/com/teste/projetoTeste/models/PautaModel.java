package com.teste.projetoTeste.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_PAUTAS")
public class PautaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPauta;
    private String titulo;

    @Transient
    private Long quantidadeVotos;

    public Long getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(Long idPauta) {
        this.idPauta = idPauta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getQuantidadeVotos() {
        return quantidadeVotos;
    }

    public void setQuantidadeVotos(Long quantidadeVotos) {
        this.quantidadeVotos = quantidadeVotos;
    }
}
