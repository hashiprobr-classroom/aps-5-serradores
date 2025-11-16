package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConversaTest {
    private static final double DELTA=0.01;
    private Conversa conversa;
    private Prompt promptFalso(double valor){
        Prompt prompt=mock(Prompt.class);
        when(prompt.calculaPreco()).thenReturn(valor);
        return prompt;
    }
    @BeforeEach
    public void setUp(){
        Usuario usuarioFalso=mock(Usuario.class);
        conversa=new Conversa(usuarioFalso);

    }
    @Test
    public void subTotalVazio(){
        assertEquals(0,conversa.calculaSubTotal());
    }
    @Test
    public void subTotal(){
        conversa.adiciona(promptFalso(5));
        conversa.adiciona(promptFalso(5.1));
        conversa.adiciona(promptFalso(5.23));
        assertEquals(15.33,conversa.calculaSubTotal(),DELTA);

    }
    @Test
    public void porPostVazio(){
        IllegalStateException e=assertThrows(IllegalStateException.class,()->{conversa.calculaSubMedia();});
        assertEquals("Nenhum prompt!",e.getMessage());

    }
    @Test
    public void porPost(){
        conversa.adiciona(promptFalso(5));
        conversa.adiciona(promptFalso(5.1));
        conversa.adiciona(promptFalso(5.23));
        assertEquals(5.11,conversa.calculaSubMedia(),DELTA);


    }



}
