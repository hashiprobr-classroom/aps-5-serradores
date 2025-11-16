package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class cobradorTest {
    private Cobrador cobrador;
    private List<Conversa> conversas;
    private Usuario usuarioFalso(String email){
        Usuario usuario=mock(Usuario.class);
        when(usuario.getEmail()).thenReturn(email);
        return usuario;
    }
    private Conversa conversaFalsa(Usuario usuario ,double valor){
        Conversa conversa = mock(Conversa.class);
        when(conversa.calculaSubTotal()).thenReturn(valor);
        when(conversa.getUsuario()).thenReturn(usuario);
        return conversa;

    }
    @BeforeEach
    public void setUp(){
        conversas = new ArrayList<>();
        cobrador = new Cobrador(conversas);
    }
    @Test
    public void nenhumaValida(){
        List<Conversa>conversas= new ArrayList<>();
        Cobrador cobrador = new Cobrador(conversas);
        assertEquals(0,cobrador.calculaTotal(usuarioFalso("teste@")));
    }
    @Test
    public void umaValida() {
        Usuario joseph = usuarioFalso("joseph@");
        Usuario mario = usuarioFalso("mario@");
        Usuario joao = usuarioFalso("joao@");
        conversas.add(conversaFalsa(joseph,10));
        conversas.add(conversaFalsa(mario,10));
        conversas.add(conversaFalsa(joao,10));
        Cobrador cobrador = new Cobrador(conversas);
        assertEquals(10,cobrador.calculaTotal(joseph));

    }

    @Test
    public void DuasValida(){
        Usuario joseph = usuarioFalso("joseph@");
        Usuario mario = usuarioFalso("mario@");
        conversas.add(conversaFalsa(mario,10));
        conversas.add(conversaFalsa(joseph,10));
        conversas.add(conversaFalsa(joseph,10));
        assertEquals(20,cobrador.calculaTotal(joseph));


    }
    @Test
    public void TresValida(){
        Usuario joseph = usuarioFalso("joseph@");
        conversas.add(conversaFalsa(joseph,10));
        conversas.add(conversaFalsa(joseph,10));
        conversas.add(conversaFalsa(joseph,10));

    }




}
