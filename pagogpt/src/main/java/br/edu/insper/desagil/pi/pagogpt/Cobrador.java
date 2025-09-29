package br.edu.insper.desagil.pi.pagogpt;

import java.util.List;

public class Cobrador {
    private List<Conversa>conversas;
    public Cobrador( List<Conversa>conversas){
        this.conversas=conversas;

    }
    public double calculaTotal(Usuario usuario) {
        double total =0;
        String email= usuario.getEmail();
        for(Conversa conversa: conversas){
            Usuario usuario_analisado = conversa.getUsuario();
            String email_analisado= usuario_analisado.getEmail();
            if(email.equals(email_analisado)){
                total+=conversa.calculaSubTotal();
            }

        }
        return total;


    }


}
