package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromptGratuitoTest {
    private Prompt e;

    @Test
    public void precoCurto(){
        e=new PromptGratuito("pergunta",10);
        assertEquals(0,e.calculaPreco());

    }
    @Test
    public void precoLongo(){
        e=new PromptGratuito("pergunta longa", 10);
        assertEquals(14,e.calculaPreco());
    }

}
