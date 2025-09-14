package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromptGratuitoTest {
    @Test
    public void precoCurto(){
        PromptGratuito prompt = new PromptGratuito( "pergunta",  10);
        assertEquals(0,prompt.calculaPreco());
    }

    @Test
    void precoLongo() {
        PromptGratuito prompt = new PromptGratuito("pergunta longa",10);
        assertEquals(14,prompt.calculaPreco());
    }
}
