package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PromptPagoTest {
    @Test
    void constroi() {
        PromptPago prompt = new PromptPago("pergunta", 0.5);
        assertEquals("pergunta", prompt.getPergunta());
        assertNull(prompt.getResposta());

    }

    @Test
    void mudaResposta() {
        PromptPago prompt = new PromptPago("pergunta", 0.5);
        prompt.setResposta("resposta");
        assertEquals("resposta",prompt.getResposta());
    }

    @Test
    void preco() {
        PromptPago prompt = new PromptPago("pergunta", 0.1);
        assertEquals(0.8,prompt.calculaPreco(),1e-2);
    }
}

