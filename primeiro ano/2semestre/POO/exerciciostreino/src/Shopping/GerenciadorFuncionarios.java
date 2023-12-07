package Shopping;
import java.util.List;
import java.util.ArrayList;

public class GerenciadorFuncionarios {
    private List<Funcionario> funcionarios;

    public GerenciadorFuncionarios() {
        funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    public void listarFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

    public List<Funcionario> listarFuncionariosPorDepartamento(String departamento) {
        List<Funcionario> funcionariosDepartamento = new ArrayList<>();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getDepartamento().equals(departamento)) {
                funcionariosDepartamento.add(funcionario);
            }
        }
        return funcionariosDepartamento;
    }

    public double calcularMediaSalarios() {
        double somaSalarios = 0;
        for (Funcionario funcionario : funcionarios) {
            somaSalarios += funcionario.getSalario();
        }
        return somaSalarios / funcionarios.size();
    }

    public Funcionario encontrarFuncionarioMaiorSalario() {
        Funcionario funcionarioMaiorSalario = null;
        double maiorSalario = Double.NEGATIVE_INFINITY; // Correção feita aqui
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getSalario() > maiorSalario) {
                maiorSalario = funcionario.getSalario();
                funcionarioMaiorSalario = funcionario;
            }
        }
        return funcionarioMaiorSalario;
    }
    
}
