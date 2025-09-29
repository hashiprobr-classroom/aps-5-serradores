package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConversaTest {
    private static final double DELTA = 0.01;
    private Conversa conversa;

    @BeforeEach
    public void setUp(){
        Usuario usuario = new Usuario("josephperl@gmail.com", "Joseph");
        conversa= new Conversa(usuario);
    }
    @Test
    public void subTotalVazio(){
        assertEquals(0,conversa.calculaSubTotal());
    }
    @Test
    public void subTotal(){
        Prompt prompt1=mock(PromptGratuito.class);
        when(prompt1.calculaPreco()).thenReturn(1.0);
        Prompt prompt2=mock(PromptGratuito.class);
        when(prompt2.calculaPreco()).thenReturn(1.1);
        Prompt prompt3=mock(PromptGratuito.class);
        when(prompt3.calculaPreco()).thenReturn(1.11);
        conversa.adiciona(prompt1);
        conversa.adiciona(prompt2);
        conversa.adiciona(prompt3);
        assertEquals(3.21,conversa.calculaSubTotal(),DELTA);


    }

    @Test
    public void porPostVazio(){
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> conversa.calculaSubMedia());
        assertEquals("Nenhum prompt!", exception.getMessage());
    }
    @Test
    public void porPost() {
        Prompt prompt1 = mock(PromptGratuito.class);
        when(prompt1.calculaPreco()).thenReturn(1.0);
        Prompt prompt2 = mock(PromptGratuito.class);
        when(prompt2.calculaPreco()).thenReturn(1.1);
        Prompt prompt3 = mock(PromptGratuito.class);
        when(prompt3.calculaPreco()).thenReturn(1.11);
        conversa.adiciona(prompt1);
        conversa.adiciona(prompt2);
        conversa.adiciona(prompt3);
        assertEquals(1.07, conversa.calculaSubMedia(), DELTA);
    }



}
