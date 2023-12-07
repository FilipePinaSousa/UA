package aula12;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class ContadorOrganizador {
    private TreeMap<String, Integer> contador = new TreeMap<>();
    private List<String> linha;

    public ContadorOrganizador() throws IOException {
        linha = Files.readAllLines(Paths.get("biblia-em-txt.txt"));
    }

    private void contador() {
        for (int i = 0; i < linha.size(); i++) {
            String[] palavras = linha.get(i).split("[\\s]");
            for (int j = 0; j < palavras.length; j++) {
                String palavra = palavras[j].toLowerCase();
                contador.put(palavra, contador.getOrDefault(palavra, 0) + 1);
            }
        }
    }

    private void organizador() {
        Map<String, Integer> contador_ordenado = new TreeMap<>(contador);
        contador_ordenado = contador_ordenado.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, TreeMap::new));
        contador = new TreeMap<>(contador_ordenado);
    }

    @Override
    public String toString() {
        return "Palavra: " + contador + " | " + "Contador: " + contador.values().stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        try {
            ContadorOrganizador biblia = new ContadorOrganizador();
            biblia.contador();
            biblia.organizador();
            System.out.println(biblia);
        } catch (IOException e) {
            System.out.println("Ficheiro não encontrado");
        }
    }
}
