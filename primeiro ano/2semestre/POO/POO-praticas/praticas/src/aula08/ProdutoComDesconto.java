package aula08;

public class ProdutoComDesconto implements Produto {
    private String nome;
    private double preco;
    private int quantidade;
    private int desconto;

    public ProdutoComDesconto(String nome, double preco, int quantidade, int desconto) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.desconto = desconto;
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
    public int getDesconto() {
        return desconto;
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
        return "ProdutoComDesconto [desconto=" + desconto + ", nome=" + nome + ", preco=" + preco + ", quantidade="
                + quantidade + "]";
    }
    
}
   
    

