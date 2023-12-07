package Cabine;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Cruzeiro {

	private String nome, data;
	private int duracao;
	private String[] cidades;
	
	Comparator<Cabine> ordenar =  new Comparator <Cabine> () {
		public int compare(Cabine a, Cabine b){
			return(a.getNumero() >= b.getNumero() ? 1:-1);
		}
	};
	
	private Set <Cabine> listaCabines = new TreeSet <> (ordenar);

	public Cruzeiro(String nome, String[] cidades, String data) {
		super();
		this.nome = nome;
		this.cidades = cidades;
		this.data = data;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public void add(Cabine c){
		listaCabines.add(c);
	}

	public Set<Cabine> getListaCabines() {
		return listaCabines;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Navio "+nome + ", partida em " +data+ "\n");
		sb.append("Itinerário: "+Arrays.toString(cidades)+"\n");
		for (Cabine c: listaCabines)
			sb.append(c+"\n");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(cidades);
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + duracao;
		result = prime * result + ((listaCabines == null) ? 0 : listaCabines.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((ordenar == null) ? 0 : ordenar.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cruzeiro other = (Cruzeiro) obj;
		if (!Arrays.equals(cidades, other.cidades))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (duracao != other.duracao)
			return false;
		if (listaCabines == null) {
			if (other.listaCabines != null)
				return false;
		} else if (!listaCabines.equals(other.listaCabines))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (ordenar == null) {
			if (other.ordenar != null)
				return false;
		} else if (!ordenar.equals(other.ordenar))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
}
