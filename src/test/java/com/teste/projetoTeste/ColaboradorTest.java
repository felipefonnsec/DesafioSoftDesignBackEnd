package com.teste.projetoTeste;

import com.teste.projetoTeste.models.ColaboradorModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ColaboradorTest {

    //teste para verificatr se retorna o nome
    @Test
    public void testGetColaborador(){
        ColaboradorModel colaborador = new ColaboradorModel();
        colaborador.setNome("Carlos");

        assertEquals("Nome teste", colaborador.getNome());
    }

    //teste para verificar se o colaborado esta sendo criado corretamente
    @Test
    public void testSetColaborador(){
        ColaboradorModel colaborador = new ColaboradorModel();
        colaborador.setNome("Nome (verificacao)");

        assertEquals("Nome teste", colaborador.getNome());
    }
}
