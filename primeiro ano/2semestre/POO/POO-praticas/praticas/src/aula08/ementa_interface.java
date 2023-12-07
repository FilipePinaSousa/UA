package aula08;
import java.util.ArrayList;
import java.util.List;

class Ingrediente {
    private String nome;

    public Ingrediente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Prato {
    private String nome;
    private List<Ingrediente> ingredientes;

    public Prato(String nome) {
        this.nome = nome;
        this.ingredientes = new ArrayList<>();
    }

    public void adicionarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public void removerIngrediente(Ingrediente ingrediente) {
        if (ingredientes.contains(ingrediente)) {
            ingredientes.remove(ingrediente);
        } else {
            System.out.println("Ingrediente não encontrado no prato.");
        }
    }

    public String getNome() {
        return nome;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }
}

class Ementa {
    private List<Prato> pratos;

    public Ementa() {
        this.pratos = new ArrayList<>();
    }

    public void adicionarPrato(Prato prato) {
        pratos.add(prato);
    }

    public void removerPrato(Prato prato) {
        if (pratos.contains(prato)) {
            pratos.remove(prato);
        } else {
            System.out.println("Prato não encontrado na ementa.");
        }
    }

    public void imprimirEmenta() {
        System.out.println("Ementa:");
        for (Prato prato : pratos) {
            System.out.println("- " + prato.getNome());
        }
    }
}

public class ementa_interface {
    public static void main(String[] args) {
        // Criar ingredientes
        Ingrediente carne = new Ingrediente("Carne");
        Ingrediente peixe = new Ingrediente("Peixe");
        Ingrediente cereal = new Ingrediente("Cereal");
        Ingrediente legume = new Ingrediente("Legume");

        // Criar pratos
        Prato prato1 = new Prato("Prato 1");
        Prato prato2 = new Prato("Prato 2");

        // Adicionar ingredientes aos pratos
        prato1.adicionarIngrediente(carne);
        prato1.adicionarIngrediente(legume);
        prato2.adicionarIngrediente(peixe);
        prato2.adicionarIngrediente(cereal);

        // Criar ementa
        Ementa ementa = new Ementa();

        // Adicionar pratos à ementa
        ementa.adicionarPrato(prato1);
        ementa.adicionarPrato(prato2);

        // Imprimir ementa
        ementa.imprimirEmenta();

        // Remover prato da ementa
        ementa.removerPrato(prato1);

        // Imprimir ementa novamente
        ementa.imprimirEmenta();
    }
}
