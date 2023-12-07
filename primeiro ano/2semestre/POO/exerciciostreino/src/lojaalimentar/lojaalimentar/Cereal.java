package lojaalimentar;

public class Cereal  extends Alimento{
	
	private TIPO_CEREAL tipo;

	public Cereal(String nome, double preco, int calorias, String validade) {
		super(nome, preco, calorias, validade);
		}

	public Cereal(String nome, double preco, int calorias, String validade, TIPO_CEREAL tipo) {
		super(nome, preco, calorias, validade);
		this.tipo = tipo;
	}

	public void setComp(TIPO_CEREAL tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		StringBuilder sb =  new StringBuilder();
		sb.append("[Refrigerante]");
		sb.append(super.toString());
		sb.append(", Contituição:"+tipo );
		return sb.toString();
	}
	
	
	

}
