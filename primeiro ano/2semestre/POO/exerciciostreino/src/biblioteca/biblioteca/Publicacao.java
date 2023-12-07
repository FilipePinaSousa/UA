package biblioteca;

public abstract class Publicacao {
	
	private String titulo, editora;

	
	public Publicacao(String titulo) {
		super();
		this.titulo = titulo;
	}

	public Publicacao(String titulo, String editora) {
		super();
		this.titulo = titulo;
		this.editora = editora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	@Override
	public String toString() {
		return "Título:" + titulo + ", Editora:" + editora;
	}
	
	
	
	

}
