package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PromptPagoTest {
    private static final double DELTA=0.01;
    @Test
    public void constroi(){
        PromptPago promptPago= new PromptPago("pergunta",0.01);
        assertEquals("pergunta",promptPago.getPergunta());
        assertNull(promptPago.getResposta());
    }
    @Test
    public void mudaResposta(){
        PromptPago promptPago= new PromptPago("pergunta",0.01);
        promptPago.setResposta("resposta");
        assertEquals("resposta",promptPago.getResposta());
    }
    @Test
    public void preco(){
        PromptPago promptPago= new PromptPago("pergunta",0.1);
        assertEquals(0.8,promptPago.calculaPreco());

    }
}
