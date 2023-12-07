package lojaalimentar;

public class Refrigerante  extends Alimento implements Temperatura{
	
	private int tMax=5, tMin=3;

	public Refrigerante(String nome, double preco, int calorias, String validade) {
		super(nome, preco, calorias, validade);
		}
	
	@Override
	public void setTemp(int max, int min) {
		tMax= max;
		tMin= min;
	}

	@Override
	public String toString() {
		StringBuilder sb =  new StringBuilder();
		sb.append("[Refrigerante]");
		sb.append(super.toString());
		sb.append(", Tª Max:"+tMax + ", Tª Min:" + tMin);
		return sb.toString();
	}
	
	
	
	

}
