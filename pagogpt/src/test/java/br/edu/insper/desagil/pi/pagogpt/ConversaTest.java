package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConversaTest {
    private PromptPago promptfalso(double valor){
        PromptPago p = mock(PromptPago.class);
        when(p.calculaPreco()).thenReturn(valor);
        return p;
    }
    private Conversa c;
    private static final double DELTA=0.01;
    @BeforeEach
    public void setUp(){
        Usuario usuariofalso=mock(Usuario.class);
        c=new Conversa(usuariofalso);
    }
    @Test
    public void subTotalVazio(){
        assertEquals(0,c.calculaSubTotal());
    }
    @Test
    public void subTotal(){
        c.adiciona(promptfalso(1));
        c.adiciona(promptfalso(1.1));
        c.adiciona(promptfalso(1.11));
        assertEquals(3.21,c.calculaSubTotal(),DELTA);
    }
    @Test
    public void porPostVazio(){
        IllegalStateException e= assertThrows(IllegalStateException.class,()->{c.calculaSubMedia();});
        assertEquals("Nenhum prompt!",e.getMessage());
    }
    @Test
    public void porPost(){
        c.adiciona(promptfalso(1));
        c.adiciona(promptfalso(1.1));
        c.adiciona(promptfalso(1.11));
        assertEquals(1.07,c.calculaSubMedia(),DELTA);
    }

}
