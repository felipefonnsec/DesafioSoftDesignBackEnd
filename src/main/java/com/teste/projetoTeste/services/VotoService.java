package com.teste.projetoTeste.services;

import com.teste.projetoTeste.models.ColaboradorModel;
import com.teste.projetoTeste.models.PautaModel;
import com.teste.projetoTeste.models.VotoModel;
import com.teste.projetoTeste.repositories.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoService {
    @Autowired
    VotoRepository votoRepository;

    //verifica os votos
    public boolean verificaVoto(PautaModel pauta, ColaboradorModel colaborador){
        return votoRepository.existsByPautaAndColaborador(pauta, colaborador);
    }
    public VotoModel voto(VotoModel voto){
        return votoRepository.save(voto);
    }

}
