package teste2020;
import java.util.Objects;

public abstract class Produto implements PVP {
    private String codigo;
    private int quantidade;
    private double preco_base;
    private int id = 0;
    static int nextId = 1000;


    public Produto(String codigo, int quantidade, double preco_base) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.preco_base = preco_base;
        this.id = nextId;
        nextId++;
    }


    public int getId() {
        return this.id;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco_base() {
        return this.preco_base;
    }

    public void setPreco_base(double preco_base) {
        this.preco_base = preco_base;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Produto)) {
            return false;
        }
        Produto produto = (Produto) o;
        return Objects.equals(codigo, produto.codigo) && quantidade == produto.quantidade && preco_base == produto.preco_base;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, quantidade, preco_base);
    }

    @Override
    public String toString() {
        return
            " codigo= " + getCodigo() + "'" +
            ", quantidade= " + getQuantidade() + " " +
            ", preco_base= " + getPreco_base();
    }
    
    public abstract double precoVendaAoPublico();

    public abstract String getDescricao();

    public abstract int getStock();
    
}
