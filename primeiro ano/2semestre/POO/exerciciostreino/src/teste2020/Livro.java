package teste2020;

import java.util.*;
import java.util.Objects;

public class Livro extends Produto {
    private String titulo;
    private List<Autor> autores = new ArrayList<Autor>();
    

    public Livro(String codigo, int quantidade, double preco_base, String titulo, List<Autor> autores) {
        super(codigo, quantidade, preco_base);
        this.titulo = titulo;
        this.autores = autores;

    }

    public Livro(String titulo, double preco_base){
        super("L", 0, preco_base);
        this.titulo = titulo;
    }

    public Livro(String titulo, double preco_base,List<Autor> autores){
        super("L", 0, preco_base);
        this.autores = autores;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public List<Autor> getLista() {
        return this.autores;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }


    public double precoVendaAoPublico() {
        double preco = getPreco_base();
        preco = preco * 1.06; //adiciona IVa de 6%
        return preco;
    }

    public void add(Autor autor) {
        this.autores.add(autor);
    }

    public void setStock(int quantidade) {
        setQuantidade(quantidade);
    }

    public int getStock() {
        return getQuantidade();
    }

    public void addStock(int quantidade) {
        setQuantidade(getQuantidade() + quantidade);
    }

    public int numeroAutores(){
        return getLista().size();
    }

    public String autores(){
        String autores = "";
        for(Autor autor : this.autores){
            autores += autor.getNome() + ", ";
        }

        autores = autores.substring(0, autores.length() - 2);

        return autores;
    }

    public boolean vender(int quantidade) {
        if (getQuantidade() >= quantidade) {
            setQuantidade(getQuantidade() - quantidade);
            return true;
        }
        return false;
    }

    public List<Autor> getAutores() {
        return this.autores;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Livro)) {
            return false;
        }
        Livro livro = (Livro) o;
        return Objects.equals(titulo, livro.titulo) && Objects.equals(autores, livro.autores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autores);
    }


    @Override
    public String toString() {
        return
            "Titulo= " + getTitulo() + " " +
            ", Autores= " + getLista() + " " +
            ", Codigo= " + getCodigo() + " " +
            ", Quantidade= " + getQuantidade() + " " +
            ", Preco_base= " + getPreco_base();
    }


    public String getDescricao() {
        return getTitulo();
    }

}
