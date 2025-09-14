package br.edu.insper.desagil.pi.cobasi;

public class Tutor {
    private String nome;
    private String endereco;
    private String telefone;

    public Tutor(String nome){
        this.nome = nome;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String resumoTutor(){
        String sumary = "Tutor: " + nome + "\n";
        if(endereco != null){
            sumary += "Endereço: " + endereco + "\n";
        }
        if(telefone != null){
            sumary += "Telefone: " + telefone + "\n";
        }
        return sumary;
    }

}
