package Cabine;

public class Suite extends Cabine implements ImplementsExtras{
	
	private int numQuartos;
	private Extra extra;
	
	public Suite(int numero, int capacidade) {
		super(numero, capacidade);
	}

	public Suite(int numero, int capacidade, int numQuartos) {
		super(numero, capacidade);
		this.numQuartos= numQuartos;
	}

	public Suite(int numero, int capacidade,  int numQuartos , String[] p) {
		super(numero, capacidade, p);
		this.numQuartos= numQuartos;
	}

	public int getNumQuartos() {
		return numQuartos;
	}

	public void setNumQuartos(int numQuartos) {
		this.numQuartos = numQuartos;
	}

	@Override
	public void pacoteExtra(Extra e) {
		extra=e;
	}

	@Override
	public String toString() {
		StringBuilder sb  = new StringBuilder();
		sb.append("Suite c/ " + numQuartos + " quartos ");
		if (extra !=null){
			sb.append(" "+extra + " Extra ");}
		sb.append(super.toString());
		
		return sb.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((extra == null) ? 0 : extra.hashCode());
		result = prime * result + numQuartos;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Suite other = (Suite) obj;
		if (extra != other.extra)
			return false;
		if (numQuartos != other.numQuartos)
			return false;
		return true;
	}

	
	

	
	
	
	
	
	
	

}
