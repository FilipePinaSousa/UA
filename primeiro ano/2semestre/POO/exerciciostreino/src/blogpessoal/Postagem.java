package blogpessoal;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Postagem {
    private String titulo;
    private String autor;
    private String conteudo;
    private boolean publicada;

    public Postagem(String titulo, String autor, String conteudo, boolean publicada) {
        this.titulo = titulo;
        this.autor = autor;
        this.conteudo = conteudo;
        this.publicada = publicada;
    }

    public void novaPostagem() {
        try (PrintWriter writer = new PrintWriter("blog.txt")) {
            writer.println(titulo);
            writer.println(autor);
            writer.println(conteudo);
            writer.println(publicada);
        } catch (IOException e) {
            System.out.println("Erro ao criar a nova postagem: " + e.getMessage());
        }
    }

    public void editarPostagem() {
        try (PrintWriter writer = new PrintWriter("blog.txt")) {
            writer.println(titulo);
            writer.println(autor);
            writer.println(conteudo);
            writer.println(publicada);
        } catch (IOException e) {
            System.out.println("Erro ao editar a postagem: " + e.getMessage());
        }
    }

    public static List<Postagem> lerPostagens() {
        List<Postagem> postagens = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(Paths.get("blog.txt"));

            for (int i = 0; i < linhas.size(); i += 4) {
                String titulo = linhas.get(i);
                String autor = linhas.get(i + 1);
                String conteudo = linhas.get(i + 2);
                boolean publicada = Boolean.parseBoolean(linhas.get(i + 3));

                Postagem postagem = new Postagem(titulo, autor, conteudo, publicada);
                postagens.add(postagem);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler as postagens: " + e.getMessage());
        }

        return postagens;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public boolean isPublicada() {
        return publicada;
    }

    public void setPublicada(boolean publicada) {
        this.publicada = publicada;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Postagem)) {
            return false;
        }
        Postagem postagem = (Postagem) o;
        return Objects.equals(titulo, postagem.titulo) && Objects.equals(autor, postagem.autor) && Objects.equals(conteudo, postagem.conteudo) && publicada == postagem.publicada;
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, conteudo, publicada);
    }
}

