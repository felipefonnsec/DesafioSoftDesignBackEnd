package com.teste.projetoTeste.services;

import com.teste.projetoTeste.models.ColaboradorModel;
import com.teste.projetoTeste.repositories.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService {

    @Autowired
    ColaboradorRepository colaboradorRepository;

    public ColaboradorModel saveColaborador(ColaboradorModel colaboradorModel){
        return colaboradorRepository.save(colaboradorModel);
    }
    public List<ColaboradorModel> listarColaborador (){
        return colaboradorRepository.findAll();
    }

    public ColaboradorModel obterPorId(Long id){
        return colaboradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado"));
    }
}
