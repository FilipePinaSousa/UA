package blogpessoal;

import java.util.List;
import java.util.Scanner;

public class postagemapp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("----- Blog Pessoal -----");
            System.out.println("1. Criar nova postagem");
            System.out.println("2. Editar uma postagem");
            System.out.println("3. Exibir todas as postagens");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após a leitura do número

            switch (opcao) {
                case 1:
                    criarPostagem();
                    break;
                case 2:
                    editarPostagem();
                    break;
                case 3:
                    exibirPostagens();
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void criarPostagem() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- Criar Nova Postagem -----");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Conteúdo: ");
        String conteudo = scanner.nextLine();
        System.out.print("Publicada (True/False): ");
        boolean publicada = scanner.nextBoolean();

        Postagem postagem = new Postagem(titulo, autor, conteudo, publicada);
        postagem.novaPostagem();

        System.out.println("Postagem criada com sucesso!");
    }

    private static void editarPostagem() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- Editar Postagem -----");
        System.out.print("Título da postagem a ser editada: ");
        String titulo = scanner.nextLine();

        List<Postagem> postagens = Postagem.lerPostagens();
        boolean encontrada = false;

        for (Postagem postagem : postagens) {
            if (postagem.getTitulo().equals(titulo)) {
                encontrada = true;

                System.out.print("Novo título: ");
                String novoTitulo = scanner.nextLine();
                System.out.print("Novo autor: ");
                String novoAutor = scanner.nextLine();
                System.out.print("Novo conteúdo: ");
                String novoConteudo = scanner.nextLine();
                System.out.print("Publicada (True/False): ");
                boolean novaPublicada = scanner.nextBoolean();

                postagem.setTitulo(novoTitulo);
                postagem.setAutor(novoAutor);
                postagem.setConteudo(novoConteudo);
                postagem.setPublicada(novaPublicada);
                postagem.editarPostagem();

                System.out.println("Postagem editada com sucesso!");
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Postagem não encontrada.");
        }
    }

    private static void exibirPostagens() {
        System.out.println("----- Todas as Postagens -----");

        List<Postagem> postagens = Postagem.lerPostagens();

        if (postagens.isEmpty()) {
            System.out.println("Nenhuma postagem encontrada.");
        } else {
            for (Postagem postagem : postagens) {
                System.out.println("Título: " + postagem.getTitulo());
                System.out.println("Autor: " + postagem.getAutor());
                System.out.println("Conteúdo: " + postagem.getConteudo());
                System.out.println("Publicada: " + postagem.isPublicada());
                System.out.println();
            }
        }
    }
}
