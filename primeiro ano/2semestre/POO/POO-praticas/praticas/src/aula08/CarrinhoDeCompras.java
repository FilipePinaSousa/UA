package aula08;

public class CarrinhoDeCompras {
    private Produto[] produtos;
    private int quantidade;

    public CarrinhoDeCompras() {
        produtos = new Produto[10];
        quantidade = 0 ;
    }

    public void listarProdutos() {
        System.out.println("Lista de Produtos:");
        for (int i = 0; i < quantidade; i++) {
            System.out.println("Produto #" + (i + 1) + ": " + produtos[i].getNome());
        }
    }

    public void adicionarProduto(Produto p, int quantidade) {
        if (quantidade < produtos.length && quantidade >= 0) {
            produtos[this.quantidade] = p;
            this.quantidade++;
            System.out.println("Produto adicionado com sucesso!");
        } else {
            System.out.println("Não foi possível adicionar o produto.");
        }
    }
    
    public double calcularTotal() {
        double total = 0.0;
        for (int i = 0; i < quantidade; i++) {
            if (produtos[i] instanceof ProdutoComDesconto) {
                ProdutoComDesconto p = (ProdutoComDesconto) produtos[i];
                total += p.getPreco() * p.getQuantidade() * (1 - p.getDesconto() / 100.0);
            } else {
                total += produtos[i].getPreco() * produtos[i].getQuantidade();
            }
        }
        return total;
    }
    
}