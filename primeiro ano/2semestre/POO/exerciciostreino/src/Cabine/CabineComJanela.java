package Cabine;

public class CabineComJanela extends Cabine implements ImplementsExtras{

	private TipoDeJanela tipo;
	private Extra extra;

	public CabineComJanela(int numero, int capacidade, TipoDeJanela tipo) {
		super(numero, capacidade);
		this.tipo = tipo;
	}

	public CabineComJanela(int numero, int capacidade, TipoDeJanela tipo,String[] p) {
		super(numero, capacidade, p);
		this.tipo = tipo;
		}

	
	public void setTipoJanela(TipoDeJanela tipo) {
		this.tipo = tipo;
	}

	@Override
	public void pacoteExtra(Extra e) {
		extra=e;
	}

	@Override
	public String toString() {
		StringBuilder sb  = new StringBuilder();
		sb.append("Cabine com Janela " + tipo +" ");
		if (extra !=null){
			sb.append(extra + " Extra ");}
		sb.append(super.toString());
		
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((extra == null) ? 0 : extra.hashCode());
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
		CabineComJanela other = (CabineComJanela) obj;
		if (extra != other.extra)
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	
	
	
	
	
}
