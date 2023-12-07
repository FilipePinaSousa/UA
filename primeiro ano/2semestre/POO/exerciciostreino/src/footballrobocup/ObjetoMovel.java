package footballrobocup;

public abstract class ObjetoMovel {

	private int x, y, velocidade;
	private double distancia;
	
	
	public ObjetoMovel() {
		x=0;
		y=0;
	}

	public ObjetoMovel(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public ObjetoMovel(int x, int y, double distancia) {
		this.x = x;
		this.y = y;
		this.distancia = distancia;
	}
	
	public void move (int x, int y){
		this.x=x;
		this.y=y;
		distancia = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
	}
	
	public void move (int x, int y, int velocidade){
		this.x=x;
		this.y=y;
		this.velocidade=velocidade;
		distancia = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
	}
	
	

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public double getDistancia() {
		return distancia;
	}

	public int getVelocidade() {
		return velocidade;
	}

	@Override
	public String toString() {
		return "ObjetoMovel [x=" + x + ", y=" + y + ", distancia=" + distancia + ", velocidade=" + velocidade + "]";
	}
	
	

	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(distancia);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(velocidade);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + x;
		result = prime * result + y;
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
		ObjetoMovel other = (ObjetoMovel) obj;
		if (Double.doubleToLongBits(distancia) != Double.doubleToLongBits(other.distancia))
			return false;
		if (Double.doubleToLongBits(velocidade) != Double.doubleToLongBits(other.velocidade))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
	
	
	
	
}
