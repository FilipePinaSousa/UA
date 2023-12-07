package hotel;
import java.util.Random;
import java.util.Objects;
import java.util.HashMap;
import java.util.Scanner;

public class Quarto {
    private Boolean reservado;
    private HashMap<String, Integer> tiposDeQuarto = new HashMap<>();

    public Quarto(Boolean reservado, float preco) {
        this.reservado = reservado;
        this.tiposDeQuarto.put("Simples", 100);
        this.tiposDeQuarto.put("Duplo", 200);
        this.tiposDeQuarto.put("Triplo", 300);
        this.tiposDeQuarto.put("Quadruplo", 400);
        this.tiposDeQuarto.put("Vip", 500);
        this.tiposDeQuarto.put("Presidencial", 1000);
        // Adicione os outros tipos de quarto aqui
    }

    public Boolean isReservado() {
        return this.reservado;
    }

    public Boolean getReservado() {
        return this.reservado;
    }

    public void setReservado(Boolean reservado) {
        this.reservado = reservado;
    }

  

    public HashMap<String, Integer> getTiposDeQuarto() {
        return this.tiposDeQuarto;
    }

    public boolean estalivre() {
        Random random = new Random();
        return !reservado && random.nextBoolean();
    }

    public String selecionarTipoQuarto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tipos de quarto disponíveis: ");
        for (String tipo : tiposDeQuarto.keySet()) {
            System.out.println(tipo);
        }
        System.out.print("Escolha o tipo de quarto desejado: ");
        String escolha = scanner.nextLine();
        if (tiposDeQuarto.containsKey(escolha)) {
            return escolha;
        } else {
            System.out.println("Tipo de quarto inválido. Será atribuído o tipo de quarto padrão.");
            return "Simples"; // Retornar o primeiro tipo de quarto como padrão
        }
    }

    public static void main(String[] args) {
        Quarto quarto = new Quarto(false, 100);

        if (quarto.estalivre()) {
            System.out.println("O quarto está livre. Pode ser reservado.");
        } else {
            System.out.println("O quarto está ocupado. Não pode ser reservado.");
        }

        String tipoEscolhido = quarto.selecionarTipoQuarto();
        System.out.println("Tipo de quarto escolhido: " + tipoEscolhido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservado,  tiposDeQuarto);
    }

    @Override
    public String toString() {
        return "{" +
            " reservado='" + isReservado() + "'" +
            
            ", tiposDeQuarto='" + getTiposDeQuarto() + "'" +
            "}";
    }
}
