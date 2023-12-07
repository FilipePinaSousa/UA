package teste2020;
import java.util.Objects;

public class Documentario extends Produto {
    private String titulo;
    private int ano;
    private int duracao;

    public Documentario(String codigo, int quantidade, double preco_base, String titulo, int ano, int duracao) {
        super("D", quantidade, preco_base);
        this.titulo = titulo;
        this.ano = ano;
        this.duracao = duracao;
    }


    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getDuracao() {
        return this.duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Documentario)) {
            return false;
        }
        Documentario documentario = (Documentario) o;
        return Objects.equals(titulo, documentario.titulo) && ano == documentario.ano && duracao == documentario.duracao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, ano, duracao);
    }

    @Override
    public String toString() {
        return
            "Titulo= " + getTitulo() + " " +
            ", Ano= " + getAno() + " " +
            ", Duracao= " + getDuracao() + " " +
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
        return getTitulo();
    }


}
