package ecossistema;

import java.util.ArrayList;

public class Planta extends Organismo {
    private int tamanho;
    private ArrayList<String> habilidades;
    private int taxaCrescimento;

    // Construtor
    public Planta(String nome, int idade, String localizacao, int tamanho, ArrayList<String> habilidades, int taxaCrescimento) {
        super(nome, idade, localizacao);
        this.tamanho = tamanho;
        this.habilidades = habilidades;
        this.taxaCrescimento = taxaCrescimento;
    }

    // Getters e Setters
    public int getTamanho() {
        return tamanho;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public int getTaxaCrescimento() {
        return taxaCrescimento;
    }

    // Implementação do método realizarAcao() da classe abstrata
    @Override
    public void realizarAcao() {
        // Lógica específica para plantas
    }
}
