package br.edu.insper.desagil.pi.pagogpt;

public class Usuario {
    private String email;
    private String nome;

    public Usuario(String email,String nome){
        this.email=email;
        this.nome=nome;
    }
    public String getNome(){
        return nome;
    }
    public String getEmail(){
        return email;
    }
}
