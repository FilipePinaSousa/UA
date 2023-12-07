package Shopping;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class GerenciadorFuncionarioscomLambdas {
    private List<Funcionario> funcionarios;

    public GerenciadorFuncionarioscomLambdas() {
        funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    public void listarFuncionarios() {
        funcionarios.forEach(System.out::println);
    }

    public List<Funcionario> listarFuncionariosPorDepartamento(String departamento) {
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getDepartamento().equals(departamento))
                .collect(Collectors.toList());
    }

    public double calcularMediaSalarios() {
        return funcionarios.stream()
                .mapToDouble(Funcionario::getSalario)
                .average()
                .orElse(0);
    }

    public Funcionario encontrarFuncionarioMaiorSalario() {
        return funcionarios.stream()
                .max((funcionario1, funcionario2) -> Double.compare(funcionario1.getSalario(), funcionario2.getSalario()))
                .orElse(null);
    }
}
