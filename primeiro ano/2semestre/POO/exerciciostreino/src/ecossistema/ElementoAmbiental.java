package ecossistema;
import java.util.Objects;

public class ElementoAmbiental {
    private String clima;
    private double temperatura;
    private String disponibilidadeRecursos;

    // Construtor
    public ElementoAmbiental(String clima, double temperatura, String disponibilidadeRecursos) {
        this.clima = clima;
        this.temperatura = temperatura;
        this.disponibilidadeRecursos = disponibilidadeRecursos;
    }

    // Métodos para simular mudanças nas condições ambientais
    public void alterarClima(String novoClima) {
        this.clima = novoClima;
    }

    public void alterarTemperatura(double novaTemperatura) {
        this.temperatura = novaTemperatura;
    }

    public void alterarDisponibilidadeRecursos(String novaDisponibilidadeRecursos) {
        this.disponibilidadeRecursos = novaDisponibilidadeRecursos;
    }
}