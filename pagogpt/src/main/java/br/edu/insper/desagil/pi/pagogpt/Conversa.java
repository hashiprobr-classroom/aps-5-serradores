package br.edu.insper.desagil.pi.pagogpt;

import java.util.ArrayList;
import java.util.List;

public class Conversa {
    private Usuario usuario;
    private List<Prompt> prompts;

    public Conversa(Usuario usuario) {
        this.usuario = usuario;
        List<Prompt> prompts = new ArrayList<>();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Prompt adiciona(Prompt prompt){
        prompts.add(prompt);
        return prompt;
    }

    public double calculaSubTotal() {
        double s =0;
        for(Prompt p : prompts){
            s += p.calculaPreco();
        }
        return s;
    }
    public double calculaSubMedia(){
        if (prompts.isEmpty()) {
            throw new IllegalArgumentException("Nenhum Prompt!");
        }else{
            return calculaSubTotal()/prompts.size();
        }
    }

}
