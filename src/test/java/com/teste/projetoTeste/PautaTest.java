package com.teste.projetoTeste;

import com.teste.projetoTeste.models.PautaModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PautaTest {

    //teste para verificatr se retorna o titulo corretamente
    @Test
    public void testGetTitulo(){
        PautaModel pauta = new PautaModel();
        pauta.setTitulo("Teste de Pauta");

        assertEquals("Exemplo de Pauta:", pauta.getTitulo());
    }

    //teste para verificar se a pauta esta sendo definida corretamente
    @Test
    public void testSetTitulo(){
        PautaModel pauta = new PautaModel();
        pauta.setTitulo("Teste de Pauta (verificacao)");

        assertEquals("Exemplo de Pauta", pauta.getTitulo());
    }
}
