package com.teste.projetoTeste.controllers;

import com.teste.projetoTeste.models.ColaboradorModel;
import com.teste.projetoTeste.repositories.ColaboradorRepository;
import com.teste.projetoTeste.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ColaboradorController {

    @Autowired
    ColaboradorService colaboradorService;
    @Autowired
    ColaboradorRepository colaboradorRepository;

    @PostMapping("/colaborador")
    public ResponseEntity<ColaboradorModel> save(@RequestBody ColaboradorModel colaboradorModel){
        if (colaboradorRepository.existsByNome(colaboradorModel.getNome())){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        ColaboradorModel colaborador = colaboradorService.saveColaborador(colaboradorModel);
        return new ResponseEntity<>(colaborador, HttpStatus.CREATED);
    }

    //Apenas para teste
    @GetMapping("/colaboradorList")
    public ResponseEntity<List<ColaboradorModel>> listar(){
        List<ColaboradorModel> colaborador = colaboradorService.listarColaborador();
        return new ResponseEntity<>(colaborador, HttpStatus.OK);
    }
}
