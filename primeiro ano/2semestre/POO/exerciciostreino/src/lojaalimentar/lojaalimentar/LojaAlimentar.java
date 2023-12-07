package lojaalimentar;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class LojaAlimentar {

	private String nome, endereco;
	Set <Alimento> listaAlimentos = new HashSet <> ();
	
	Comparator <Alimento> ordenar =  new Comparator <Alimento>(){
			public int compare(Alimento a, Alimento b){
				return (a.getNome().compareTo(b.getNome()));
			}};
			
	Set <Alimento> listaAlimentosOrdenados = new TreeSet <> (ordenar);		
	
	public LojaAlimentar(String nome, String endereco){
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public void add( Alimento a){
		listaAlimentos.add(a);
	}
	
	public void ordenar(){
		for(Alimento a: listaAlimentos){
			if(a instanceof Temperatura)
				listaAlimentosOrdenados.add(a);
		}
		System.out.println("A2)");
		System.out.println("Alimentos Ordenados");
		for(Alimento a: listaAlimentosOrdenados){
			System.out.println(a);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb =  new StringBuilder();
		sb.append(nome + ", Morada:" + endereco + "\n");
		for (Alimento a: listaAlimentos)
			sb.append(a+"\n");
		return sb.toString();
	}
	
	
	
	
}
