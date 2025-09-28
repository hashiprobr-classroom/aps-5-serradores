package br.edu.insper.desagil.pi.cobasi;

import java.time.LocalDate;

public class HistoricoGato extends Historico {
    private String doenca;

    public HistoricoGato(String nome, LocalDate dataNascimento, double peso, String doenca ){
        super(nome,dataNascimento,peso);
        this.doenca = doenca;
    }

    @Override
    public  String resumo(){
        return "Animal: Gato\n" + detalhesBasicos() + "Doenca: " + doenca + "\n";
    }
}
