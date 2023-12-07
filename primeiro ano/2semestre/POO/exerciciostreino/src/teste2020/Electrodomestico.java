package teste2020;
import java.util.Objects;

public class Electrodomestico extends Produto {
    private String tipo;
    private String marca;
    private String modelo;
    private double potencia;
    private ClasseEnergetica classe;

    public Electrodomestico(String tipo, String marca, String modelo, double potencia, double preco_base) {
        super("E",0,preco_base);
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
    }

    public Electrodomestico(String tipo, String marca, String modelo, double preco_base) {
        super("E",0,preco_base);
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
    }

    public void setClasse(ClasseEnergetica classe) {
        this.classe = classe;
    }

    public ClasseEnergetica getClasse() {
        return this.classe;
    }

    public String getDescricao() {
        return getTipo() + ":" + getMarca() + "/" + getModelo();
    }


    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public double getPotencia() {
        return this.potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
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

    public boolean vender(int quantidade) {
        if (getQuantidade() >= quantidade) {
            setQuantidade(getQuantidade() - quantidade);
            return true;
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Electrodomestico)) {
            return false;
        }
        Electrodomestico electrodomestico = (Electrodomestico) o;
        return Objects.equals(tipo, electrodomestico.tipo) && Objects.equals(marca, electrodomestico.marca) && Objects.equals(modelo, electrodomestico.modelo) && potencia == electrodomestico.potencia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, marca, modelo, potencia);
    }

    @Override
    public String toString() {
        return "{" +
            " tipo='" + getTipo() + "'" +
            ", marca='" + getMarca() + "'" +
            ", modelo='" + getModelo() + "'" +
            ", potencia='" + getPotencia() + "'" +
            "}";
    }
    

    public double precoVendaAoPublico() {
        double preco = getPreco_base();
        preco = preco * 1.23; //adiciona IVa de 23%
        return preco;
    }
    


}


