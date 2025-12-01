package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PromptPagoTest {
    private PromptPago p;
    private static final double DELTA=0.01;
    @BeforeEach
    public void setUp(){
        p=new PromptPago("pergunta",0.1);
    }
    @Test
    public void constroi(){
        assertNull(p.getResposta());
        assertEquals("pergunta",p.getPergunta());
    }
    @Test
    public void mudaResposta(){
        p.setResposta("s");
        assertEquals("s",p.getResposta());
    }
    @Test
    public void preco(){
        assertEquals(0.8,p.calculaPreco(),DELTA);
    }

}
