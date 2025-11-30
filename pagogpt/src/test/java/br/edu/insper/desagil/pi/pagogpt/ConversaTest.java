package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConversaTest {
    private static final double DELTA= 0.01;
    private Conversa s;
    private Prompt promptfalso(double preco){
        PromptGratuito prompt = mock(PromptGratuito.class);
        when(prompt.calculaPreco()).thenReturn(preco);
        return prompt;
    }
    @BeforeEach
    public void setUp(){
        Usuario usuariofalso=mock(Usuario.class);
        s= new Conversa(usuariofalso);
    }
    @Test
    public void subTotalVazio(){
        assertEquals(0,s.calculaSubTotal());
    }
    @Test
    public void subTotal(){
        s.adiciona(promptfalso(1));
        s.adiciona(promptfalso(1.1));
        s.adiciona(promptfalso(1.11));
        assertEquals(3.21,s.calculaSubTotal(),DELTA);

    }
    @Test
    public void porPostVazio(){
        IllegalStateException e=assertThrows(IllegalStateException.class,()->{s.calculaSubMedia();});
        assertEquals("Nenhum prompt!",e.getMessage());
    }
    @Test
    public void porPost(){
        s.adiciona(promptfalso(1));
        s.adiciona(promptfalso(1.1));
        s.adiciona(promptfalso(1.11));
        assertEquals(1.07,s.calculaSubTotal(),DELTA);

    }

}
