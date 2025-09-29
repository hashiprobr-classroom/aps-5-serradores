package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PromptPagoTest {
    private Prompt e;
    private static final double DELTA = 0.01;


    @Test
    public void constroi(){
        e=new PromptPago(5,"pergunta");
        assertEquals("pergunta",e.getPergunta());
        assertNull(e.getResposta());
    }
    @Test
    public void mudaResposta(){
        e=new PromptPago(5,"pergunta");
        e.setResposta("resposta");
        assertEquals("resposta",e.getResposta());
    }
    @Test

    public void preco(){
        e=new PromptPago(0.1,"pergunta");
        assertEquals(0.8,e.calculaPreco());

    }

}

