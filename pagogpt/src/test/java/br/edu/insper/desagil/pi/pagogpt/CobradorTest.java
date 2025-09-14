package br.edu.insper.desagil.pi.pagogpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CobradorTest {
    private Usuario usuario1;

    private Conversa conversa1;
    private Conversa conversa2;
    private Conversa conversa3;

    private List<Conversa> conversas;

    @BeforeEach
    void setUp() {
        usuario1 = new Usuario("test1@gmail.com","test1");
        Usuario usuario2 = new Usuario("test2@gmail.com", "test2");
        Usuario usuario3 = new Usuario("test3@gmail.com", "test3");

        conversa1 = new Conversa(usuario1);
        conversa2 = new Conversa(usuario2);
        conversa3 = new Conversa(usuario3);

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
        PromptPago prompt = new PromptPago("teste1",1);

        conversa1.adiciona(prompt);

        Cobrador cobrador1 = new Cobrador(conversas);
        assertEquals(6,cobrador1.calculaTotal(usuario1));

    }

    @Test
    void duasValidas() {
        conversa1 = new Conversa(usuario1);
        conversa2 = new Conversa(usuario1);

        conversas = new ArrayList<>();
        conversas.add(conversa1);
        conversas.add(conversa2);

        PromptPago prompt1 = new PromptPago("teste1",1);
        PromptPago prompt2 = new PromptPago("teste2",1);

        conversa1.adiciona(prompt1);
        conversa2.adiciona(prompt2);

        Cobrador cobrador1 = new Cobrador(conversas);
        assertEquals(12,cobrador1.calculaTotal(usuario1));
    }

    @Test
    void tresValidas() {
        conversa1 = new Conversa(usuario1);
        conversa2 = new Conversa(usuario1);
        conversa3 = new Conversa(usuario1);

        conversas = new ArrayList<>();
        conversas.add(conversa1);
        conversas.add(conversa2);
        conversas.add(conversa3);

        PromptPago prompt1 = new PromptPago("teste1",1);
        PromptPago prompt2 = new PromptPago("teste2",1);
        PromptPago prompt3 = new PromptPago("teste3",1);

        conversa1.adiciona(prompt1);
        conversa2.adiciona(prompt2);
        conversa3.adiciona(prompt3);

        Cobrador cobrador1 = new Cobrador(conversas);
        assertEquals(18,cobrador1.calculaTotal(usuario1));
    }
}
