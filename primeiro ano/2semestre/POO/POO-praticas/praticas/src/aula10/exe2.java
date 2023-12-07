package aula10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

 class library {
     
        Map<String, List<livro>> booksByGenre;
    
        public library() {
            this.booksByGenre = new TreeMap<>();
        }
    
        public void addlivro(String genero, livro book) {
            List<livro> books = booksByGenre.getOrDefault(genero, new ArrayList<>());
            books.add(book);
            booksByGenre.put(genero, books);
        }
    
        public void removelivro(String genero, livro book) {
            List<livro> books = booksByGenre.getOrDefault(genero, new ArrayList<>());
            books.remove(book);
            booksByGenre.put(genero, books);
        }
    
        public void editlivro(String genero, livro oldlivro, livro newlivro) {
            List<livro> books = booksByGenre.getOrDefault(genero, new ArrayList<>());
            books.remove(oldlivro);
            books.add(newlivro);
            booksByGenre.put(genero, books);
        }
    
        public livro getRandomlivroByGenre(String genero) {
            List<livro> books = booksByGenre.getOrDefault(genero, new ArrayList<>());
            if (books.isEmpty()) {
                return null;
            }
            int randomIndex = (int) (Math.random() * books.size());
            return books.get(randomIndex);
        }
    
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("livros by Genre:\n");
            for (String genero : booksByGenre.keySet()) {
                sb.append(genero + ":\n");
                for (livro book : booksByGenre.get(genero)) {
                    sb.append("- " + book.toString() + "\n");
                }
            }
            sb.append("\nGenres:\n");
            for (String genero : booksByGenre.keySet()) {
                sb.append("- " + genero + "\n");
            }
            sb.append("\nlivros:\n");
            for (List<livro> books : booksByGenre.values()) {
                for (livro book : books) {
                    sb.append("- " + book.toString() + "\n");
                }
            }
            return sb.toString();
        }
    }
    
    public class exe2 {
        public static void main(String[] args) {
            library library = new library();
            
            livro book1 = new livro("Dom Casmurro", "Machado de Assis", 1899);
            livro book2 = new livro("A Hora da Estrela", "Clarice Lispector", 1977);
            livro book3 = new livro("Os Maias", "Eça de Queirós", 1888);
            livro book4 = new livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", 1881);
            livro book5 = new livro("Grande Sertão: Veredas", "João Guimarães Rosa", 1956);
            livro book6 = new livro("O Alienista", "Machado de Assis", 1882);
            livro book7 = new livro("Capitães da Areia", "Jorge Amado", 1937);
            livro book8 = new livro("O Cortiço", "Aluísio Azevedo", 1890);
            
            library.addlivro("Conto", book2);
            library.addlivro("Conto", book4);
            library.addlivro("Conto", book6);
            library.addlivro("Ficção", book5);
            library.addlivro("Romance", book1);
            library.addlivro("Romance", book3);
            library.addlivro("Romance", book8);
            library.addlivro("Infantil", new livro("O Menino Maluquinho", "Ziraldo", 1980));
            library.addlivro("Infantil", new livro("A Bolsa Amarela", "Lygia Bojunga Nunes", 1976));
            library.addlivro("Infantil", new livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943));
            library.addlivro("Suspense", book7);
            
            System.out.println(library.toString());
            
            library.editlivro("Conto", book4, new livro("A Cartomante", "Machado de Assis", 1884));
            library.removelivro("Ficção", book5);
            
            System.out.println(library.toString());
            
            System.out.println("\nRandom livro from 'Romance':");
            livro randomlivro = library.getRandomlivroByGenre("Romance");
            if (randomlivro != null) {
                System.out.println(randomlivro.toString());
            } else {
                System.out.println("No books found for genero 'Romance'");
            }
        }
    }
    
    

