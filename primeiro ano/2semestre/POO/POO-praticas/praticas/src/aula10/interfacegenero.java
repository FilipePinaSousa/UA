
package aula10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class interfacegenero {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int choice = 0;

            HashMap<String, List<livro>> generos = new HashMap<>();
            do {
                System.out.println("1 - Criar novo genero");
                System.out.println("2 - Mostrar generos");
                System.out.println("3 - Alterar genero");
                System.out.println("4 - Eliminar genero");
                System.out.println("5 - Adicionar livro");
                System.out.println("6 - Mostrar livros");
                System.out.println("7 - Alterar livro");
                System.out.println("8 - Eliminar livro");
                System.out.println("9 - Mostrar livros por genero");
                System.out.println("10 - escolher um genero aleatorio e mostrar os seus livros");
                System.out.println("0 - Sair");

                choice = sc.nextInt();
                sc.nextLine();

                String genero;

                switch (choice) {
                    case 1:
                        System.out.println("Introduza o genero:");
                        genero = sc.nextLine();
                        generos.put(genero, new ArrayList<livro>());
                        break;
                    case 2:
                        System.out.println("Generos:");
                        for (String g : generos.keySet()) {
                            System.out.println(g);
                        }
                        break;
                    case 3:
                        System.out.println("Introduza o genero a alterar:");
                        genero = sc.nextLine();
                        if (generos.containsKey(genero)) {
                            System.out.println("Introduza o novo genero:");
                            String novoGenero = sc.nextLine();
                            generos.put(novoGenero, generos.get(genero));
                            generos.remove(genero);
                        } else {
                            System.out.println("Genero nao encontrado.");
                        }
                        break;
                    case 4:
                        System.out.println("Introduza o genero a eliminar:");
                        genero = sc.nextLine();
                        if (generos.containsKey(genero)) {
                            generos.remove(genero);
                        } else {
                            System.out.println("Genero nao encontrado.");
                        }
                        break;
                    case 5:
                        System.out.println("Introduza o genero:");
                        genero = sc.nextLine();
                        if (generos.containsKey(genero)) {
                            System.out.println("Introduza o titulo:");
                            String titulo = sc.nextLine();
                            System.out.println("Introduza o autor:");
                            String autor = sc.nextLine();
                            System.out.println("Introduza o ano:");
                            int ano = sc.nextInt();
                            sc.nextLine();
                    
                            livro livro = new livro(titulo, autor, ano);
                            generos.get(genero).add(livro);
                        } else {
                            System.out.println("Genero nao encontrado.");
                        }
                        break;
                    case 6:
                        System.out.println("livros:");
                        for (List<livro> livros : generos.values()) {
                            for (livro livro : livros) {
                                System.out.println(livro);
                            }
                        }
                        break;
                    case 7:
                        System.out.println("Introduza o genero do livro a alterar:");
                        genero = sc.nextLine();
                        if (generos.containsKey(genero)) {
                            System.out.println("Introduza o titulo do livro a alterar:");
                            String titulo = sc.nextLine();
                            List<livro> livros = generos.get(genero);
                            for (livro livro : livros) {
                                if (livro.getTitle().equals(titulo)) {
                                    System.out.println("Introduza o novo titulo:");
                                    String novoTitulo = sc.nextLine();
                                    System.out.println("Introduza o novo autor:");
                                    String novoAutor = sc.nextLine();
                                    System.out.println("Introduza o novo ano:");
                                    int novoAno = sc.nextInt();
                                    sc.nextLine();

                                    livro.setTitle(novoTitulo);
                                    livro.setAuthor(novoAutor);
                                    livro.setYear(novoAno);
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Genero nao encontrado.");
                        }
                        break;
                    case 8:
                        System.out.println("Introduza o genero do livro a eliminar:");
                        genero = sc.nextLine();
                        if (generos.containsKey(genero)) {
                            System.out.println("Introduza o titulo do livro a eliminar:");
                            String titulo = sc.nextLine();
                            List<livro> livros = generos.get(genero);
                            for (livro livro : livros) {
                                if (livro.getTitle().equals(titulo)) {
                                    livros.remove(livro);
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Genero nao encontrado.");
                        }
                        break;
                    case 9:
                        System.out.println("Introduza o genero:");
                        genero = sc.nextLine();
                        if (generos.containsKey(genero)) {
                            System.out.println("livros do genero " + genero + ":");
                            for (livro livro : generos.get(genero)) {
                                System.out.println(livro);
                            }
                        } else {
                            System.out.println("Genero nao encontrado.");
                        }
                        break;
                    case 10:
                        int random = (int) (Math.random() * generos.size());
                        int i = 0;
                        for (String g : generos.keySet()) {
                            if (i == random) {
                                System.out.println("livros do genero " + g + ":");
                                for (livro livro : generos.get(g)) {
                                    System.out.println(livro);
                                }
                                break;
                            }
                            i++;
                        }
                        break;
                        
                    default:
                        System.out.println("Opção inválida");
                }
            } while (choice != 0);
        }
    }
}
