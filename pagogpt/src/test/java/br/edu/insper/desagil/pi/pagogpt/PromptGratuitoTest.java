package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromptGratuitoTest {
    @Test
    public void precoCurto(){
        PromptGratuito promptGratuito = new PromptGratuito("pergunta", 10);
        assertEquals(0, promptGratuito.calculaPreco());
    }
    @Test
    public void precoLongo(){
        PromptGratuito promptGratuito = new PromptGratuito("pergunta longa",10);
        assertEquals(14, promptGratuito.calculaPreco());

    }


}
