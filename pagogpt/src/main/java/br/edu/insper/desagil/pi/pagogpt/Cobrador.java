package br.edu.insper.desagil.pi.pagogpt;

import java.util.List;

public class Cobrador{
    private List<Conversa> conversas;

    public Cobrador(List<Conversa> conversas) {
        this.conversas = conversas;
    }

    public double calculaTotal(Usuario usuario){
        double soma = 0;
        for (Conversa c : conversas){
            if(c.getUsuario().getEmail().equals(usuario.getEmail())){
                soma += c.calculaSubTotal();
            }
        }
        return soma;
    }

}
