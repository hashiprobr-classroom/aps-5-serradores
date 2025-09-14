package br.edu.insper.desagil.pi.cobasi;

import java.time.LocalDate;

public class HistoricoElefante extends Historico{
    private int comida;

    public HistoricoElefante(String nome, LocalDate dataNascimento, double peso, int comida ){
        super(nome,dataNascimento,peso);
        this.comida = comida;
    }

    @Override
    public  String resumo(){
        return "Animal: Elefante\n" + detalhesBasicos() + "Comida: " + comida + "\n";
    }
}
