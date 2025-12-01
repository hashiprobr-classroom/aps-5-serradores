package br.edu.insper.desagil.pi.pagogpt;

public class PromptGratuito extends Prompt{
    private int limite;
    public PromptGratuito(String pergunta,int limite){
        super(pergunta);
        this.limite=limite;
    }
    @Override
    public double calculaPreco(){return 0.0;}

}
