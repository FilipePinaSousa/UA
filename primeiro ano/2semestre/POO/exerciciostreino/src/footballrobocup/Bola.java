package footballrobocup;

public class Bola extends ObjetoMovel{

	private CorDaBola corDaBola;
	private static int numero = 0;

	public Bola(CorDaBola corDaBola) {
		this.corDaBola = corDaBola;
		numero = 1;

	}
	public static int getnBolas(){
		return numero;
	}
	
	@Override
	public String toString() {
		return "Bola [corDaBola=" + corDaBola + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((corDaBola == null) ? 0 : corDaBola.hashCode());
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
		Bola other = (Bola) obj;
		if (corDaBola != other.corDaBola)
			return false;
		return true;
	}
	
	
	
	
	
}