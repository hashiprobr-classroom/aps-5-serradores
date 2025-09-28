package br.edu.insper.desagil.pi.cobasi;

import java.time.LocalDate;

public abstract class Historico {
    private String nome;
    private LocalDate dataNascimento;
    private double peso;

    public Historico(String nome, LocalDate dataNascimento, double peso) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.peso = peso;
    }

    public String detalhesBasicos(){
        return "Nascimento: " + dataNascimento.toString() + "\n"
                + "Peso: " + peso + "kg\n";
    }

    public String getNome(){
        return nome;
    }

    public abstract  String resumo();
}
