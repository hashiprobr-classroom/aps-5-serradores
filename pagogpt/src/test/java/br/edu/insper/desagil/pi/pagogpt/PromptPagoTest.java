package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PromptPagoTest {
    private PromptPago c;
    private static final double DELTA=0.01;
    @BeforeEach
    public void setUp(){
        c=new PromptPago("pergunta",0.1);
    }
    @Test
    public void constroi(){
        assertEquals("pergunta",c.getPergunta());
        assertNull(c.getResposta());
    }
    @Test
    public void mudaResposta(){
        c.setResposta("resposta");
        assertEquals("resposta",c.getResposta());
    }
    @Test
    public void preco(){
        assertEquals(0.8,c.calculaPreco(),DELTA);
    }


}
