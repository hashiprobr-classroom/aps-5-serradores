package br.edu.insper.desagil.pi.cobasi;

import java.time.LocalDate;

public class HistoricoCobra extends Historico {
    private boolean venenosa;

    public HistoricoCobra(String nome, LocalDate dataNascimento, double peso, boolean venenosa ){
        super(nome,dataNascimento,peso);
        this.venenosa = venenosa;
    }

    @Override
    public  String resumo(){
        return "Animal: Cobra\n" + detalhesBasicos() + "Venenosa: " + venenosa + "\n";
    }
}
