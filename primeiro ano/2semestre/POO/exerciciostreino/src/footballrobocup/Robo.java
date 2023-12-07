package footballrobocup;

public class Robo extends ObjetoMovel {

	private String id;
	private TipoJogador tipojogador;
	private int golosMarcados=0;
	
	public Robo(String id,TipoJogador tipoJogador,int x, int y) {
		super(x, y);
		this.tipojogador=tipoJogador;
		this.id=id;
	}
	
	public Robo(String id,TipoJogador tipoJogador) {
		this.tipojogador=tipoJogador;
		this.id=id;
	}
	
	public void marcaGolo(){
		golosMarcados++;
	}

	public String getId() {
		return id;
	}

	public TipoJogador getTipo() {
		return tipojogador;
	}

	public int getGolos() {
		return golosMarcados;
	}

	@Override
	public String toString() {
		return "id=" + id + ", tipo=" + tipojogador ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + golosMarcados;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tipojogador == null) ? 0 : tipojogador.hashCode());
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
		Robo other = (Robo) obj;
		if (golosMarcados != other.golosMarcados)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tipojogador != other.tipojogador)
			return false;
		return true;
	}
	
	
}
