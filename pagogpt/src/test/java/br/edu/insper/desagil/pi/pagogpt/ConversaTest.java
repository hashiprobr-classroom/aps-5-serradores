package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConversaTest {
    private Conversa conversa;

    @BeforeEach
    void setUp() {
        Usuario usuario = new Usuario("teste@gmail.com","teste");
        conversa = new Conversa(usuario);
    }

    @Test
    void subTotalVazio() {
        assertEquals(0,conversa.calculaSubTotal());
    }

    @Test
    void subTotal() {
        PromptPago prompt1 = new PromptPago("teste1",1);
        PromptPago prompt2 = new PromptPago("teste2",0.5);
        PromptPago prompt3 = new PromptPago("teste3",0.25);
        conversa.adiciona(prompt1);
        conversa.adiciona(prompt2);
        conversa.adiciona(prompt3);
        assertEquals(10.5,conversa.calculaSubTotal(),1e-2);
    }

    @Test
    void porPostVazio() {
        IllegalStateException e = assertThrows(IllegalStateException.class, () ->{
        conversa.calculaSubMedia();
        });
        assertEquals("Nenhum prompt!",e.getMessage());
    }

    @Test
    void porPost() {
        PromptPago prompt1 = new PromptPago("teste1",1);
        PromptPago prompt2 = new PromptPago("teste2",0.5);
        PromptPago prompt3 = new PromptPago("teste3",0.25);
        conversa.adiciona(prompt1);
        conversa.adiciona(prompt2);
        conversa.adiciona(prompt3);
        assertEquals(3.5,conversa.calculaSubMedia(),1e-2);
    }
}
