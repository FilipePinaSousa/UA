package biblioteca;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Biblioteca {
	
	private String nome, endereco;
	
	Comparator<Publicacao> comparador = new Comparator<Publicacao>(){
		@Override
		public int compare(Publicacao o1, Publicacao o2) {
			return( o1.getTitulo().compareTo(o2.getTitulo()));
		}
	};
	
	private Set <Publicacao> lista = new TreeSet <>(comparador);

	public Biblioteca(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public void add(Publicacao pub){
		lista.add(pub);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nome+ ", Endereço: "+endereco+"\n\n");
		for(Publicacao p : lista)
			sb.append(p +"\n");
		
	return sb.toString();
	}
	
	

	
}
