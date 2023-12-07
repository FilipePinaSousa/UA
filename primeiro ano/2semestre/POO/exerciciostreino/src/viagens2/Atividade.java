package viagens2;

public abstract class Atividade implements PontosdeInteresse {
    int identificador;
    String nome;
    public Atividade(int identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
    }
    
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
