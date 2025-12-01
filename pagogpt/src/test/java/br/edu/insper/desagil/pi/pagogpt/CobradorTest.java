package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CobradorTest {
    private Cobrador c;
    private  List<Conversa> conversas;
    private Usuario usuariofalso(String email){
        Usuario usuario= mock(Usuario.class);
        when(usuario.getEmail()).thenReturn(email);
        return usuario;
    }
    private Conversa conversafalsa(Usuario usuario,double valor){
        Conversa conversa = mock(Conversa.class);
        when(conversa.getUsuario()).thenReturn(usuario);
        when(conversa.calculaSubTotal()).thenReturn(valor);
        return conversa;
    }
    @BeforeEach
    public void setUp(){
        conversas= new ArrayList<>();
        c=new Cobrador(conversas);
    }
    @Test
    public void nenhumaValida(){
        assertEquals(0,c.calculaTotal(usuariofalso("@")));
    }
    @Test
    public void umaValida(){
        conversas.add(conversafalsa(usuariofalso("@"),10));
        conversas.add(conversafalsa(usuariofalso("@s"),10));
        conversas.add(conversafalsa(usuariofalso("@ss"),10));
        assertEquals(10,c.calculaTotal(usuariofalso("@")));
    }
    @Test
    public void duasValidas(){
        conversas.add(conversafalsa(usuariofalso("@"),10));
        conversas.add(conversafalsa(usuariofalso("@"),10));
        conversas.add(conversafalsa(usuariofalso("@ss"),10));
        assertEquals(20,c.calculaTotal(usuariofalso("@")));
    }
    @Test
    public void tresValidas(){
        conversas.add(conversafalsa(usuariofalso("@"),10));
        conversas.add(conversafalsa(usuariofalso("@"),10));
        conversas.add(conversafalsa(usuariofalso("@"),10));
        assertEquals(30,c.calculaTotal(usuariofalso("@")));
    }

    
}
