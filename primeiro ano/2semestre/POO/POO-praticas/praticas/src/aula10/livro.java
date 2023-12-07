package aula10;

import java.util.ArrayList;
import java.util.TreeMap;
public class livro {
    private String titulo;
    private String autor;
    private int ano;

    ArrayList<livro> books = new ArrayList<>();


    public livro(String titulo, String autor, int ano){
        this.titulo=titulo;
        this.autor=autor;
        this.ano=ano;
    } 

    public String getTitle(){
        return titulo;
    }

    public String getAuthor(){
        return autor;
    }

    public int getYear(){
        return ano;
    }

    public void setTitle(String titulo){
        this.titulo=titulo;
    }

    public void setAuthor(String autor){
        this.autor=autor;
    }

    public void setYear(int ano){
        this.ano=ano;
    }

    public String toString() {
        return String.format("%-6s%-6s%4d", titulo, autor, ano);
    }
    

    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null || this.getClass()!=obj.getClass()){
            return false;
        }
        livro other=(livro) obj;
        return this.titulo.equals(other.titulo) && this.autor.equals(other.autor) && this.ano==other.ano;
    }

    public livro clone(){
        livro ret=new livro(autor, autor, ano);
        ret.titulo=this.titulo;
        ret.autor=this.autor;
        ret.ano=this.ano;
        return ret;
    }

    public int compareTo(livro other){
        return this.titulo.compareTo(other.titulo);
    }



    public static livro[] sort(livro[] books){
        TreeMap<livro, Integer> map = new TreeMap<>();
        for(int i=0; i<books.length; i++){
            map.put(books[i], i);
        }
        livro[] sorted = new livro[books.length];
        int i = 0;
        for(livro livro : map.keySet()){
            sorted[i++] = livro;
        }
        return sorted;
    }
}


