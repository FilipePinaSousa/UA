package teste2020;
import java.util.*;

public class Telemovel extends Produto {
    private String marca;
    private String modelo;
    private Set<String> notas = new HashSet<String>();


    public Telemovel(String marca, String modelo, double preco_base) {
        super("T",0,preco_base);
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Set<String> getNotas() {
        return this.notas;
    }

    public void setNotas( HashSet<String> notas) {
        this.notas = notas;
    }

    public Telemovel marca(String marca) {
        setMarca(marca);
        return this;
    }

    public Telemovel modelo(String modelo) {
        setModelo(modelo);
        return this;
    }

    public Telemovel notas( HashSet<String> notas) {
        setNotas(notas);
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Telemovel)) {
            return false;
        }
        Telemovel telemovel = (Telemovel) o;
        return Objects.equals(marca, telemovel.marca) && Objects.equals(modelo, telemovel.modelo) && Objects.equals(notas, telemovel.notas);
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

    public void addNota(String nota) {
        notas.add(nota);
    }

    public boolean vender(int quantidade) {
        if (getQuantidade() >= quantidade) {
            setQuantidade(getQuantidade() - quantidade);
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo, notas);
    }

    @Override
    public String toString() {
        return 
            "Marca: " + getMarca() + " " +
            "Modelo: " + getModelo() + " " +
            "Notas: " + getNotas() + " " +
            ", Codigo= " + getCodigo() + " " +
            ", Quantidade= " + getQuantidade() + " " +
            ", Preco_base= " + getPreco_base();
    }

    public double precoVendaAoPublico() {
        double preco = getPreco_base();
        preco = preco * 1.23; //adiciona IVa de 23%
        return preco;
    }

    public String getDescricao() {
        return getMarca() + "/" + getModelo();
    }

}


