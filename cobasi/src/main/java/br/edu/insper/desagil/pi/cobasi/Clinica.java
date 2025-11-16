package br.edu.insper.desagil.pi.cobasi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Clinica {
    private List<Historico> historicos;

    public Clinica() {
        this.historicos = new ArrayList<>();
    }

    public List<Historico> getHistoricos() {
        return historicos;
    }

    public void addHistorico(Historico hitoricos) {
        historicos.add(hitoricos);
    }

    public void addHistoricoCachorro(String nome, LocalDate dataNascimento, double peso, String tipoBanho) {
        historicos.add(new HistoricoCachorro(nome, dataNascimento, peso, tipoBanho));
    }

    public void addHistoricoGato(String nome, LocalDate dataNascimento, double peso, String doenca ) {
        historicos.add(new HistoricoGato(nome, dataNascimento, peso, doenca));
    }

    public void addHistoricoCobra(String nome, LocalDate dataNascimento, double peso, boolean venenosa ) {
        historicos.add(new HistoricoCobra(nome, dataNascimento, peso, venenosa));
    }

    public void addHistoricoElefante(String nome, LocalDate dataNascimento, double peso, int comida ) {
        historicos.add(new HistoricoElefante(nome, dataNascimento, peso, comida));
    }
}
