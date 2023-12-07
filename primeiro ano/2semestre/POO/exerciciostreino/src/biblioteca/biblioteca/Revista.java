package biblioteca;
public class Revista extends Publicacao {
	
	private Periodicidade periodicidade;
	private String issn;
	
	public Revista(String titulo, String editora,Periodicidade periodicidade, String issn) {
		super(titulo,editora);
		this.periodicidade = periodicidade;
		this.issn = issn;
	}
	
	public Revista(String titulo, String editora,Periodicidade periodicidade) {
		super(titulo,editora);
		this.periodicidade = periodicidade;
	}
	
	public Revista(String titulo, String editora, String issn) {
		super(titulo,editora);
		this.issn = issn;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("[Revista] "+ super.toString());
		if(periodicidade!=null)
			sb.append(", Periodiciade:" + periodicidade);
		if (issn != null)
			sb.append(", ISSN:" + issn);
		return sb.toString();
	}
	
	
	

	

}
