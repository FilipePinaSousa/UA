package Cabine;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public abstract class Cabine {
	
	Comparator <String> ordenarPassageiros = new Comparator<String>() {
		public int compare (String a, String b){
			return a.compareTo(b);
		}
	};

	private int numero, capacidade;
	private Set<String> passageiros = new TreeSet<>(ordenarPassageiros);

	
	public Cabine(int numero, int capacidade) {
		this.numero = numero;
		this.capacidade = capacidade;
	}
	
	public Cabine(int numero, int capacidade, String[]p) {
		if (p.length>capacidade){
			throw new IllegalArgumentException();
		}
		else{
			for(String elemento:p)
				passageiros.add(elemento);
		}
		this.numero = numero;
		this.capacidade = capacidade;
	}

	public void setPassageiros(String[] p ) {
		if (p.length>capacidade){
			throw new IllegalArgumentException();
		}
		else{
			for(String elemento:p)
				passageiros.add(elemento);
		}
	}

	public int getNumero() {
		return numero;
	}
	
	public void setMaxOcupantes (int capacidade) {
		this.capacidade = capacidade;
	}

	
	public Set<String> getPassageiros() {
		return passageiros;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ Nº" + numero+ " (max "+capacidade + " pessoas ) : ");
		if(passageiros.size()!= 0)
			sb.append(passageiros.toString()+"]");
		else{
			sb.append("Disponível para Venda!]");
		}
		return sb.toString();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacidade;
		result = prime * result + numero;
		result = prime * result + ((ordenarPassageiros == null) ? 0 : ordenarPassageiros.hashCode());
		result = prime * result + ((passageiros == null) ? 0 : passageiros.hashCode());
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
		Cabine other = (Cabine) obj;
		if (capacidade != other.capacidade)
			return false;
		if (numero != other.numero)
			return false;
		if (ordenarPassageiros == null) {
			if (other.ordenarPassageiros != null)
				return false;
		} else if (!ordenarPassageiros.equals(other.ordenarPassageiros))
			return false;
		if (passageiros == null) {
			if (other.passageiros != null)
				return false;
		} else if (!passageiros.equals(other.passageiros))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
