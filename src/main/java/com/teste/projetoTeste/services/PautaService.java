package com.teste.projetoTeste.services;

import com.teste.projetoTeste.models.PautaModel;
import com.teste.projetoTeste.repositories.PautaRepository;
import com.teste.projetoTeste.repositories.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PautaService {
    @Autowired
    PautaRepository pautaRepository;
    @Autowired
    VotoRepository votoRepository;

    // cadastrando pauta
    public PautaModel save(PautaModel pautaModel){
        return pautaRepository.save(pautaModel);
    }

    //Listar
    public List<PautaModel> listar(){
        return pautaRepository.findAll();
    }

    //buscar pauta
    public PautaModel obterPorId(Long id){
        return pautaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pauta não encontrada"));
    }

    public long contarVotosPorPauta(PautaModel pauta){
        Long quantidadeVotos = votoRepository.countByPauta(pauta);
        return quantidadeVotos != null ? quantidadeVotos : 0;
    }
}
