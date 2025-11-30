package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CobradorTest {
    private Usuario usuariofalso(String email){
        Usuario usuario = mock(Usuario.class);
        when(usuario.getEmail()).thenReturn(email);
        return usuario;
    }
    private Conversa conversafalsa(Usuario usuario , double total){
        Conversa conversa = mock(Conversa.class);
        when(conversa.getUsuario()).thenReturn(usuario);
        when(conversa.calculaSubTotal()).thenReturn(total);
        return conversa;
    }
    private Cobrador d;
    private List<Conversa>conversas;
    @BeforeEach
    public void setUp(){
        conversas= new ArrayList<>();
        d=new Cobrador(conversas);
    }
    @Test
    public void nenhumaValida(){
        assertEquals(0,d.calculaTotal(usuariofalso("teste@")));
    }
    @Test
    public void umavalida(){
        conversas.add(conversafalsa(usuariofalso("@"),10));
        conversas.add(conversafalsa(usuariofalso("@g"),10));
        conversas.add(conversafalsa(usuariofalso("@gs"),10));
        assertEquals(10,d.calculaTotal(usuariofalso("@")));

    }
    @Test
    public void duasValida(){
        conversas.add(conversafalsa(usuariofalso("@"),10));
        conversas.add(conversafalsa(usuariofalso("@"),20));
        conversas.add(conversafalsa(usuariofalso("@s"),10));
        assertEquals(30,d.calculaTotal(usuariofalso("@")));


    }
    @Test
    public void tresValida(){
        conversas.add(conversafalsa(usuariofalso("@"),10));
        conversas.add(conversafalsa(usuariofalso("@"),20));
        conversas.add(conversafalsa(usuariofalso("@"),10));
        assertEquals(40,d.calculaTotal(usuariofalso("@")));


    }
}
