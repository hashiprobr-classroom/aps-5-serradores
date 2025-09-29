package br.edu.insper.desagil.pi.pagogpt;

public class PromptPago extends Prompt {
    private double fator;
    public PromptPago(double fator,String pergunta){
        super(pergunta);
        this.fator=fator;
    }
    @Override
    public double calculaPreco(){
        String pergunta = getPergunta();
        int tamanho= pergunta.length();
        return tamanho*fator;
    }



}
