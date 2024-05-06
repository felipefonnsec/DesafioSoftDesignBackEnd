package com.teste.projetoTeste.controllers;

import com.teste.projetoTeste.models.PautaModel;
import com.teste.projetoTeste.responses.PautaResponse;
import com.teste.projetoTeste.services.PautaService;
import com.teste.projetoTeste.services.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PautaController {
    @Autowired
    PautaService pautaService;

    //efetua o cadastro
    @PostMapping("/pautas")
    public ResponseEntity<String> criarPauta(@RequestBody PautaModel pauta){
        PautaModel pautaModel = pautaService.save(pauta);
        return new ResponseEntity<>(pautaModel.getTitulo(), HttpStatus.CREATED);
    }

    //lista de pautas
    @GetMapping("/pautas")
    public ResponseEntity<List<PautaModel>> listarPauta(){
        List<PautaModel> pautas = pautaService.listar();

        for(PautaModel pauta : pautas) {
            long quantidadeVotos = pautaService.contarVotosPorPauta(pauta);
            pauta.setQuantidadeVotos(quantidadeVotos);
        }

        return new ResponseEntity<>(pautas, HttpStatus.OK);
    }

    //busca pauta por id
    @GetMapping("/pautas/{id}")
    public ResponseEntity<PautaResponse> listarPorId(@PathVariable(value = "id") Long id){
        PautaModel pauta = pautaService.obterPorId(id);
        long quantidadeVotos = pautaService.contarVotosPorPauta(pauta);

        PautaResponse pautaResponse = new PautaResponse();
        pautaResponse.setTitulo(pauta.getTitulo());
        pautaResponse.setQuantidadeVotos(quantidadeVotos);
        return new ResponseEntity<>(pautaResponse, HttpStatus.OK);
    }
}
