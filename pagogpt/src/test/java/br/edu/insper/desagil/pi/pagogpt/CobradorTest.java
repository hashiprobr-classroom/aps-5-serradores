package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CobradorTest {
    private Conversa conversa2;
    private List<Conversa> conversas;

    @BeforeEach
    void setUp() {
        Usuario usuario1 = new Usuario("test1@gmail.com", "test1");
        Usuario usuario2 = new Usuario("test2@gmail.com", "test2");
        Usuario usuario3 = new Usuario("test3@gmail.com", "test3");

        Conversa conversa1 = new Conversa(usuario1);
        conversa2 = new Conversa(usuario2);
        Conversa conversa3 = new Conversa(usuario3);

        conversas = new ArrayList<>();
        conversas.add(conversa1);
        conversas.add(conversa2);
        conversas.add(conversa3);
    }

    @Test
    void nenhumaValida() {
        Usuario usuarioFora  = new Usuario("fora@gmail.com","outro");

        Cobrador cobrador1 = new Cobrador(conversas);
        assertEquals(0,cobrador1.calculaTotal(usuarioFora));
    }

    @Test
    void umaValida() {
        Usuario usuario = new Usuario("u1@gmail.com", "u1");

        Conversa conversa1 = mock(Conversa.class);

        when(conversa1.getUsuario()).thenReturn(usuario);

        when(conversa1.calculaSubTotal()).thenReturn(10.0);

        Cobrador cobrador = new Cobrador(List.of(conversa1, conversa2));

        assertEquals(10.0, cobrador.calculaTotal(usuario), 1e-2);
    }

    @Test
    void duasValidas() {
        Usuario usuario = new Usuario("u1@gmail.com", "u1");

        Conversa conversa1 = mock(Conversa.class);
        Conversa conversa2 = mock(Conversa.class);

        when(conversa1.getUsuario()).thenReturn(usuario);
        when(conversa2.getUsuario()).thenReturn(usuario);

        when(conversa1.calculaSubTotal()).thenReturn(10.0);
        when(conversa2.calculaSubTotal()).thenReturn(5.5);

        Cobrador cobrador = new Cobrador(List.of(conversa1, conversa2));

        assertEquals(15.5, cobrador.calculaTotal(usuario), 1e-2);
    }


    @Test
    void tresValidas() {
        Usuario usuario = new Usuario("u1@gmail.com", "u1");

        Conversa conversa1 = mock(Conversa.class);
        Conversa conversa2 = mock(Conversa.class);
        Conversa conversa3 = mock(Conversa.class);

        when(conversa1.getUsuario()).thenReturn(usuario);
        when(conversa2.getUsuario()).thenReturn(usuario);
        when(conversa3.getUsuario()).thenReturn(usuario);

        when(conversa1.calculaSubTotal()).thenReturn(10.0);
        when(conversa2.calculaSubTotal()).thenReturn(5.5);
        when(conversa3.calculaSubTotal()).thenReturn(2.25);

        Cobrador cobrador = new Cobrador(List.of(conversa1, conversa2, conversa3));

        assertEquals(17.75, cobrador.calculaTotal(usuario), 1e-2);
    }
}
