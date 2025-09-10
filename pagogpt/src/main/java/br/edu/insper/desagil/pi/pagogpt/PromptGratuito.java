package br.edu.insper.desagil.pi.pagogpt;

public class PromptGratuito extends Prompt {
    private int limite;

    public PromptGratuito(String pergunta, int limite) {
        super(pergunta);
        this.limite = limite;
    }

    @Override
    public double calculaPreco() {
        if (getPergunta().length() < limite){
            return 0;
        }else{
            return getPergunta().length();
        }
    }
}
