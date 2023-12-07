package biblioteca;

public class Jornal extends Publicacao {
	
	private Ver ver;
	private Periodicidade periodicidade;
	
	public Jornal(String titulo) {
		super(titulo);
	}

	public Jornal(String titulo, Ver ver, Periodicidade periodicidade) {
		super(titulo);
		this.ver = ver;
		this.periodicidade = periodicidade;
	}
	
	public Jornal(String titulo, Ver ver) {
		super(titulo);
		this.ver = ver;
	}

	public void setPeriodicidade(Periodicidade periodicidade) {
		this.periodicidade = periodicidade;
	}

	@Override
	public String toString() {	
		StringBuilder sb = new StringBuilder();
		sb.append("[Jornal]  "+ super.toString());
		if (ver != null)
			sb.append(", Ver:" + ver);
		if(periodicidade!=null)
			sb.append(", Periodiciade:" + periodicidade);
		return sb.toString();
	}
	
	
	
	
	
	

}
