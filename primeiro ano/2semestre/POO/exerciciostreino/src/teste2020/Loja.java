package teste2020;
import java.util.*;
public class Loja {
    private String nome;
    private String endereco_web;
    private Set<Produto> produtos;

    public Loja(String nome, String endereco_web)  {
        this.nome = nome;
        this.endereco_web = endereco_web;
        this.produtos = new TreeSet<>( new Comparator<Produto>() {
            @Override
            public int compare(Produto p1, Produto p2) {
                return p1.getDescricao().compareTo(p2.getDescricao());
            }
        });
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco_web() {
        return this.endereco_web;
    }

    public void setEndereco_web(String endereco_web) {
        this.endereco_web = endereco_web;
    }

    public Set<Produto> getProdutos() {
        return this.produtos;
    }

    public void setProdutos(TreeSet<Produto> produtos) {
        this.produtos = produtos;
    }


    public void add(Produto p) {
        this.produtos.add(p);
    }

    public int totalItems() {
        int total = 0;
        for (Produto p : this.produtos) {
            total += p.getStock();
        }
        return total;
    }


    public String getProdutoPelaDescricao(String descricao) {

        for (Produto p : produtos) {

            if (p instanceof Telemovel) {
                String desc = p.getDescricao();

                String [] desc_split = p.getDescricao().split("/");

                desc = desc_split[0].toUpperCase() + "/" + desc_split[1];

                if (desc.equals(descricao)) {
                    return p.getDescricao();
                    
                }
            }

            else{
                if (p.getDescricao().equals(descricao)) {
                    return p.getDescricao();
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String str = "";
        System.out.println("Loja" + getNome() + "\n");
        str+=String.format ("%s %s %30s %6s\n", "Codigo", "Produto", "Em Stock", "PVP");
        for (Produto produto : produtos) {
            str+= String.format ("%s%d: %-25s %12s %.2f\n", produto.getCodigo(),produto.getId(), produto.getDescricao(), produto.getStock(),produto.precoVendaAoPublico());

        }
        return str;
    }


}
