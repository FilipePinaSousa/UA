package ecossistema;

import java.util.Objects;

public class Animais extends Organismo {
    private boolean velocidade;
    private String reproducao;

    public enum Dieta {
        ONIVORO,
        CARNIVORO,
        HERBIVORO
    }

    public Animais(String nome, int idade, String localizacao, boolean velocidade, String reproducao) {
        super(nome, idade, localizacao);
        this.velocidade = velocidade;
        this.reproducao = reproducao;
    }

    public boolean isVelocidade() {
        return velocidade;
    }

    public void setVelocidade(boolean velocidade) {
        this.velocidade = velocidade;
    }

    public String getReproducao() {
        return reproducao;
    }

    public void setReproducao(String reproducao) {
        this.reproducao = reproducao;
    }

    public Animais velocidade(boolean velocidade) {
        setVelocidade(velocidade);
        return this;
    }

    public Animais reproducao(String reproducao) {
        setReproducao(reproducao);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animais)) return false;
        Animais animais = (Animais) o;
        return velocidade == animais.velocidade && Objects.equals(reproducao, animais.reproducao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(velocidade, reproducao);
    }

    @Override
    public String toString() {
        return "Animais{" +
                "velocidade=" + velocidade +
                ", reproducao='" + reproducao + '\'' +
                '}';
    }

    @Override
    public void realizarAcao() {
        // Logic specific to animal action
    }
}
