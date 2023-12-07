package footballrobocup;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Equipa {

	private String nome, responsavel;
	private int golosMarcados, golosSofridos;

	Comparator <Robo> comparar = new Comparator<Robo>() {
		public int compare (Robo a, Robo b){
			return(a.getId().compareTo(b.getId()));
		}
	};

	Set<Robo> elementos = new TreeSet<> (comparar);

	public Equipa(String nome, String responsavel) {
		this.nome = nome;
		this.responsavel = responsavel;
	}
	
	public void add(Robo r){
		if(!elementos.contains(r))
		elementos.add(r);
	}
	
	public void remove (Robo r){
		elementos.remove(r);
	}

	public int getGolosMarcados() {
		for (Robo r: elementos)
			golosMarcados+= r.getGolos();
	return golosMarcados;
	}

	public Robo[] getRobos() {
		Robo[] array = (Robo[]) new Robo[elementos.size()];
		int i=0;
		for(Robo r: elementos){
			array[i] = r;
			i++;}
		return array;
	}

	
	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Equipa "+nome +", treinada por "+responsavel+ " (" + elementos.size()+ " jogadores) \n robos= ");
		for( Robo r: elementos)
			sb.append(r + " *;* ");	
		sb.append("\n  golosMarcados="+golosMarcados+"\n");
		return  sb.toString();
	}
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((elementos == null) ? 0 : elementos.hashCode());
		result = prime * result + golosMarcados;
		result = prime * result + golosSofridos;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((responsavel == null) ? 0 : responsavel.hashCode());
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
		Equipa other = (Equipa) obj;
		if (elementos == null) {
			if (other.elementos != null)
				return false;
		} else if (!elementos.equals(other.elementos))
			return false;
		if (golosMarcados != other.golosMarcados)
			return false;
		if (golosSofridos != other.golosSofridos)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (responsavel == null) {
			if (other.responsavel != null)
				return false;
		} else if (!responsavel.equals(other.responsavel))
			return false;
		return true;
	}	
}

