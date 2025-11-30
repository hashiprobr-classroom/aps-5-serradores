package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromptGratuitoTest {
    @Test
    public void precoCurto() {
        PromptGratuito c = new PromptGratuito("pergunta", 10);
        assertEquals(0, c.calculaPreco());
    }

    @Test
    public void precoLongo() {
        PromptGratuito c = new PromptGratuito("pergunta longa", 10);
        assertEquals(14, c.calculaPreco());
    }
}
