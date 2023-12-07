package jogodavelha;

import java.util.Objects;
import jogodavelha.cell.CellType;

public class Jogador {
    private String nome;
    private CellType tipoCirculo;
    private CellType tipoCruz;

    public Jogador(String nome) {
        this.nome = nome;
        this.tipoCirculo = CellType.X;
        this.tipoCruz = CellType.O;
    }

    public String getNome() {
        return nome;
    }

    public CellType getTipoCirculo() {
        return tipoCirculo;
    }

    public CellType getTipoCruz() {
        return tipoCruz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogador jogador = (Jogador) o;
        return Objects.equals(nome, jogador.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
