package com.teste.projetoTeste;

import com.teste.projetoTeste.controllers.VotoController;
import com.teste.projetoTeste.enums.EnumVoto;
import com.teste.projetoTeste.models.ColaboradorModel;
import com.teste.projetoTeste.models.PautaModel;
import com.teste.projetoTeste.models.VotoModel;
import com.teste.projetoTeste.services.ColaboradorService;
import com.teste.projetoTeste.services.PautaService;
import com.teste.projetoTeste.services.VotoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(VotoController.class)
public class VotoTeste {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    private VotoService votoService;
    @Autowired
    private PautaService pautaService;
    @Autowired
    private ColaboradorService colaboradorService;

    @Test
    public void votoTeste() throws Exception {
        PautaModel pauta = new PautaModel();
        pauta.setIdPauta(102L);

        ColaboradorModel colaborador = new ColaboradorModel();
        colaborador.setIdPauta(102L);

        VotoModel voto = new VotoModel();
        voto.setPauta(pauta);
        voto.setColaborador(colaborador);
        voto.setVoto(EnumVoto.SIM);

        //config de comportamento do objeto chamando os id's
        when(pautaService.obterPorId(102L)).thenReturn(pauta);
        when(colaboradorService.obterPorId(102L)).thenReturn(colaborador);
        when(votoService.verificaVoto(pauta, colaborador)).thenReturn(false);
        when(votoService.voto(voto)).thenReturn(voto);

        //requisisao http simulada
        mockMvc.perform(post("/votos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(" { \"pauta\": {\"idPauta\": 102}, {\"colaborador\": {\"idPauta\": 102 }, \"voto\": SIM  }"))
                .andExpect(status().isCreated())
                .andExpect((ResultMatcher) content().string("Teste de registro"));

    }
}
