package lojaalimentar;
public abstract class Alimento {
	
	private String nome, validade;
	private double preco;
	private int calorias;
	
	public Alimento(String nome, double preco, int calorias, String validade) {
		super();
		this.nome = nome;
		this.validade = validade;
		this.preco = preco;
		this.calorias = calorias;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" Nome:" + nome+", Validade:"+validade+ ", Preço:"+preco+", Calorias:"+calorias);
		return sb.toString();
	}
	
	
	
}
