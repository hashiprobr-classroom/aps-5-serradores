package br.edu.insper.desagil.pi.cobasi;

import java.time.LocalDate;

public class HistoricoCachorro extends Historico {
    private String tipoBanho;

    public HistoricoCachorro(String nome, LocalDate dataNascimento, double peso,String tipoBanho ){
        super(nome,dataNascimento,peso);
        this.tipoBanho = tipoBanho;
    }

    @Override
    public  String resumo(){
        return "Animal: Cachorro\n" + detalhesBasicos() + "Banho: " + tipoBanho + "\n";
    }

}
