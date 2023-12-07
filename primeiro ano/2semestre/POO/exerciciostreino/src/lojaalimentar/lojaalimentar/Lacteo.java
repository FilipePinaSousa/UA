package lojaalimentar;

public class Lacteo extends Alimento implements Temperatura {

	private double gordura;
	private int tMax=5, tMin=3;
	
	public Lacteo(String nome, double  preco, int calorias, String validade) {
		super(nome, preco, calorias, validade);
	}

	public Lacteo(String nome, double preco, int calorias, String validade, double gordura) {
		super(nome, preco, calorias, validade);
		this.gordura = gordura;
	}
	
	public void setGordura(double gordura) {
		this.gordura = gordura;
	}
	
	@Override
	public void setTemp(int max, int min) {
		tMax= max;
		tMin= min;
	}
	
	@Override
	public String toString() {
		StringBuilder sb =  new StringBuilder();
		sb.append("[Lacteo]");
		sb.append(super.toString());
		sb.append(", Gordura:"+gordura+", Tª Max:"+tMax + ", Tª Min:" + tMin);
		return sb.toString();
	}


	
	
	
	

}
