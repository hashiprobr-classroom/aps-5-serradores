package br.edu.insper.desagil.pi.pagogpt;

import java.util.ArrayList;
import java.util.List;

public class Conversa {
    private Usuario usuario;
    private List<Prompt>prompts;
    public Conversa(Usuario usuario){
        this.usuario=usuario;
        this.prompts= new ArrayList<>();
    }
    public Usuario getUsuario(){return usuario;}

    public void adiciona(Prompt prompt){};
    public double calculaSubTotal(){return 0.0;}
    public double calculaSubMedia(){return 0.0;}

}
