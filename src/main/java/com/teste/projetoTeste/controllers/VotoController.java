package com.teste.projetoTeste.controllers;

import com.teste.projetoTeste.models.ColaboradorModel;
import com.teste.projetoTeste.models.PautaModel;
import com.teste.projetoTeste.models.VotoModel;
import com.teste.projetoTeste.services.ColaboradorService;
import com.teste.projetoTeste.services.PautaService;
import com.teste.projetoTeste.services.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VotoController {

    @Autowired
    VotoService votoService;
    @Autowired
    PautaService pautaService;

    //efetua o novo voto e verifica se o usuário já votou
    @PostMapping("/votos")
    public ResponseEntity<?> votar(@RequestBody VotoModel voto){
        //verifica se o colaborador já votou na pauta
        if (votoService.verificaVoto(voto.getPauta(), voto.getColaborador())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O colaborador já votou");
        }

        VotoModel novoVoto = votoService.voto(voto);
        PautaModel pauta = pautaService.obterPorId(novoVoto.getPauta().getIdPauta());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pauta.getTitulo() + " - " + novoVoto.getVoto());
    }
}
