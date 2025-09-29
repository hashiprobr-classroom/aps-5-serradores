package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CobradorTest {
    private Cobrador cobrador;
    Usuario usuario1 = new Usuario("josephperl@gmail.com", "Joseph");
    Usuario usuario2 = new Usuario("josephperll@gmail.com", "Joseph");
    Usuario usuario3 = new Usuario("josephperlll@gmail.com", "Joseph");
    List<Conversa> conversas;


    @BeforeEach
    public void setUp(){
        conversas = new ArrayList<>();
        cobrador=new Cobrador(conversas);

    }
    @Test
    public void nenhumaValida(){
        assertEquals(0,cobrador.calculaTotal(usuario1));
    }
    @Test
    public void nehumaValida(){

        Conversa valida= mock(Conversa.class);
        when(valida.getUsuario()).thenReturn(usuario1);
        when(valida.calculaSubTotal()).thenReturn(2.5);
        Conversa falsa1= mock(Conversa.class);
        when(falsa1.getUsuario()).thenReturn(usuario2);
        when(falsa1.calculaSubTotal()).thenReturn(2.5);
        Conversa falsa2= mock(Conversa.class);
        when(falsa2.getUsuario()).thenReturn(usuario3);
        when(falsa2.calculaSubTotal()).thenReturn(2.5);
        conversas.add(valida);
        conversas.add(falsa1);
        conversas.add(falsa2);
        assertEquals(2.5,cobrador.calculaTotal(usuario1));


    }
    @Test

    public void duasValida(){
        Conversa valida= mock(Conversa.class);
        when(valida.getUsuario()).thenReturn(usuario1);
        when(valida.calculaSubTotal()).thenReturn(2.5);
        Conversa valida1= mock(Conversa.class);
        when(valida1.getUsuario()).thenReturn(usuario1);
        when(valida1.calculaSubTotal()).thenReturn(2.5);
        Conversa falsa= mock(Conversa.class);
        when(falsa.getUsuario()).thenReturn(usuario2);
        when(falsa.calculaSubTotal()).thenReturn(2.5);
        conversas.add(valida);
        conversas.add(valida1);
        conversas.add(falsa);
        assertEquals(5.0,cobrador.calculaTotal(usuario1));

    }
    @Test

    public void tresValida(){
        Conversa valida= mock(Conversa.class);
        when(valida.getUsuario()).thenReturn(usuario1);
        when(valida.calculaSubTotal()).thenReturn(2.5);
        Conversa valida1= mock(Conversa.class);
        when(valida1.getUsuario()).thenReturn(usuario1);
        when(valida1.calculaSubTotal()).thenReturn(2.5);
        Conversa valida2= mock(Conversa.class);
        when(valida2.getUsuario()).thenReturn(usuario1);
        when(valida2.calculaSubTotal()).thenReturn(2.5);
        conversas.add(valida);
        conversas.add(valida1);
        conversas.add(valida2);
        assertEquals(7.5,cobrador.calculaTotal(usuario1));

    }


}
