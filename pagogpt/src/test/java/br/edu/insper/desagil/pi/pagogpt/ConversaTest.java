package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        Prompt p1 = mock(Prompt.class);
        Prompt p2 = mock(Prompt.class);
        Prompt p3 = mock(Prompt.class);

        // define comportamentos
        when(p1.calculaPreco()).thenReturn(1.0);
        when(p2.calculaPreco()).thenReturn(0.5);
        when(p3.calculaPreco()).thenReturn(0.25);

        conversa.adiciona(p1);
        conversa.adiciona(p2);
        conversa.adiciona(p3);

        assertEquals(1.75, conversa.calculaSubTotal(), 1e-2);
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
        // cria mocks de Prompt
        Prompt p1 = mock(Prompt.class);
        Prompt p2 = mock(Prompt.class);
        Prompt p3 = mock(Prompt.class);

        // define comportamentos
        when(p1.calculaPreco()).thenReturn(5.0);
        when(p2.calculaPreco()).thenReturn(5.5);
        when(p3.calculaPreco()).thenReturn(5.25);

        conversa.adiciona(p1);
        conversa.adiciona(p2);
        conversa.adiciona(p3);

        assertEquals(5.25, conversa.calculaSubMedia(), 1e-2);
    }
}
