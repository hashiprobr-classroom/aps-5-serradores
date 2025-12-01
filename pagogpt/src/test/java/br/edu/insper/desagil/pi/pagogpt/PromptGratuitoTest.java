package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromptGratuitoTest {
    private PromptGratuito g;
    @BeforeEach
    public void setUp(){
        g=new PromptGratuito("pergunta",10);
    }
    @Test
    public void precoCurto(){
        assertEquals(0,g.calculaPreco());
    }
    @Test
    public void precoLongo(){
        g.setPergunta("pergunta longa");
        assertEquals(14,g.calculaPreco());
    }
}
