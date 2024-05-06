package com.teste.projetoTeste.models;

import com.teste.projetoTeste.enums.EnumVoto;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_VOTOS")
public class VotoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private PautaModel pauta;
    @ManyToOne
    private ColaboradorModel colaborador;

    private EnumVoto voto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PautaModel getPauta() {
        return pauta;
    }

    public void setPauta(PautaModel pauta) {
        this.pauta = pauta;
    }

    public ColaboradorModel getColaborador() {
        return colaborador;
    }

    public void setColaborador(ColaboradorModel colaborador) {
        this.colaborador = colaborador;
    }

    public EnumVoto getVoto() {
        return voto;
    }

    public void setVoto(EnumVoto voto) {
        this.voto = voto;
    }
}
