package biblioteca;

public class Livro extends Publicacao{

	private String autores,isbn;

	public Livro(String titulo, String editora, String autores, String isbn) {
		super(titulo, editora);
		this.autores = autores;
		this.isbn = isbn;
	}
	
	public Livro(String titulo, String editora, String autores) {
		super(titulo, editora);
		this.autores = autores;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("[Livro]   "+ super.toString());
		if (autores != null)
			sb.append(", Autores:" + autores);
		if(isbn!=null)
			sb.append(", ISBN:" + isbn);
		return sb.toString();
	}
	
	




	
	
}
