package teste2020;

public class Autor {
    private String nome;
    private int ano_nascimento;

    public Autor(String nome, int ano_nascimento) {
        this.nome = nome;
        this.ano_nascimento = ano_nascimento;
    }

    public String getNome() {
        return this.nome;
    }

    public int getAno_nascimento() {
        return this.ano_nascimento;
    }


    @Override
    public String toString() {
        return
            " Nome= " + getNome() + " " +
            ", ano_nascimento= " + getAno_nascimento();
    }

    
}
