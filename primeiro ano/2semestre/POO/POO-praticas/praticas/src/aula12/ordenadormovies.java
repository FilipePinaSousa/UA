package aula12;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class ordenadormovies {
    public static void main(String[] args) throws IOException {
        try {
            ArrayList<Movie> lista_filmes = new ArrayList<>();
            List<String> linha = Files.readAllLines(Paths.get("movies.txt"));
            HashSet<String> genero = new HashSet<>();

            // a)
            for (int i = 1; i < linha.size(); i++) {
                String[] palavras = linha.get(i).split("[\t]");
                lista_filmes.add(
                        new Movie(palavras[0], Double.parseDouble(palavras[1]), palavras[2], palavras[3],
                                Integer.parseInt(palavras[4])));
                genero.add(palavras[3]);

            }
            // b)
            lista_filmes.sort((a, b) -> b.getName().compareTo(a.getName()));
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Ordenado por Nome");
            printLista(lista_filmes);
            // c
             lista_filmes.sort((a, b) -> Double.compare(a.getScore(), b.getScore()));
             System.out.println("---------------------------------------------------------------------");
             System.out.println("Ordenado por score");
             printLista(lista_filmes);

            // d)
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Generos");
            System.out.println(genero);

            // e)
            export("myselection.txt", lista_filmes);

        } catch (IOException e) {
            System.out.println("Ficheiro não encontrado");
        }
    }

    public static void export(String file, List<Movie> lista_filmes) throws IOException {
        PrintWriter writer = new PrintWriter(file);
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Qual o genero que pretende?");
            String generoInput = sc.nextLine();
            for (Movie m : lista_filmes) {
                if (m.getGenre().equals(generoInput) && m.getScore() > 60.0) {
                    writer.println(m);
                }
            }
        }
        writer.close();
    }

    public static void printLista(ArrayList<Movie> lista) {
        for (Movie x : lista) {
            System.out.println(x);
        }
    }
}
