package Cabine;

public class CabineComVaranda extends Cabine{
	
	private TipoDeVaranda tipo;

	public CabineComVaranda(int numero, int capacidade, TipoDeVaranda tipo) {
		super(numero, capacidade);
		this.tipo = tipo;
	}

	public CabineComVaranda(int numero, int capacidade, TipoDeVaranda tipo, String[] p) {
		super(numero, capacidade, p);
		this.tipo = tipo;
	}

	public void setTipoVaranda(TipoDeVaranda tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		StringBuilder sb  = new StringBuilder();
		sb.append("Cabine com Varanda " + tipo+" ");
		
		sb.append(super.toString());
		
		return sb.toString();
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		CabineComVaranda other = (CabineComVaranda) obj;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
	
	
	

	
	
	

}
