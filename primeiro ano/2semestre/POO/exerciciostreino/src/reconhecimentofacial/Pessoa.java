package reconhecimentofacial;
import java.util.Objects;

public class Pessoa {
    private int idade;
    private Boolean gender;
    private String nome;
    
    

    
    public Pessoa(int idade, Boolean gender, String nome) {
        this.idade = idade;
        this.gender = gender;
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Boolean isGender() {
        return this.gender;
    }

    public Boolean getGender() {
        return this.gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa idade(int idade) {
        setIdade(idade);
        return this;
    }

    public Pessoa gender(Boolean gender) {
        setGender(gender);
        return this;
    }

    public Pessoa nome(String nome) {
        setNome(nome);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pessoa)) {
            return false;
        }
        Pessoa pessoa = (Pessoa) o;
        return idade == pessoa.idade && Objects.equals(gender, pessoa.gender) && Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idade, gender, nome);
    }

    @Override
    public String toString() {
        return "{" +
            " idade='" + getIdade() + "'" +
            ", gender='" + isGender() + "'" +
            ", nome='" + getNome() + "'" +
            "}";
    }



}