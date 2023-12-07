package aula08;

public class ProdutoGenerico implements Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public ProdutoGenerico(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public void adicionarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    @Override
    public void removerQuantidade(int quantidade) {
        this.quantidade -= quantidade;
    }

    @Override
    public String toString() {
        return "ProdutoGenerico [nome=" + nome + ", preco=" + preco + ", quantidade=" + quantidade + "]";
    }

    @Override
    public int getDesconto() {
        throw new UnsupportedOperationException("Unimplemented method 'getDesconto'");
    }
    
}

    

