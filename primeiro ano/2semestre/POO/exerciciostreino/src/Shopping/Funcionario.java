package Shopping;
import java.util.Objects;

public class Funcionario {
    private String nome;  
    private String departamento;
    private double salario;
    

   
    public Funcionario(String nome, String departamento, double salario) {
        this.nome = nome;
        this.departamento = departamento;
        this.salario = salario;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Funcionario nome(String nome) {
        setNome(nome);
        return this;
    }

    public Funcionario departamento(String departamento) {
        setDepartamento(departamento);
        return this;
    }

    public Funcionario salario(double salario) {
        setSalario(salario);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Funcionario)) {
            return false;
        }
        Funcionario funcionario = (Funcionario) o;
        return Objects.equals(nome, funcionario.nome) && Objects.equals(departamento, funcionario.departamento) && salario == funcionario.salario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, departamento, salario);
    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", departamento='" + getDepartamento() + "'" +
            ", salario='" + getSalario() + "'" +
            "}";
    }



}
