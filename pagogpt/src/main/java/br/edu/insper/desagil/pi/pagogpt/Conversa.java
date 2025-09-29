package br.edu.insper.desagil.pi.pagogpt;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Conversa {
    private Usuario usuario;
    private List<Prompt>prompts;
    public Conversa(Usuario usuario){
        this.usuario= usuario;
        this.prompts= new ArrayList<>();

    }
    public Usuario getUsuario(){
        return usuario;
    }
    public void adiciona(Prompt prompt){
        prompts.add(prompt);
    }
    public double calculaSubTotal(){
        double total =0.0;
        for(Prompt prompt: prompts){
            total+=prompt.calculaPreco();
        }
        return total;
    }
    public double calculaSubMedia(){
        if (prompts.isEmpty()) {
            throw new IllegalStateException("Nenhum prompt!");
        }else{
            return calculaSubTotal()/prompts.size();
        }
    }

}
