package viagens2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Gastronomia extends Atividade{
    List<Restaurante> restaurantes = new ArrayList<>();

    
    public Gastronomia(int identificador, String nome) {
        super(identificador, nome);
    }

    public Gastronomia(int identificador, String nome, List<Restaurante> restaurantes) {
        super(identificador, nome);
        this.restaurantes = restaurantes;
    }

    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(List<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }
    
	public List<Restaurante> getLista() {
		return restaurantes;
	}

    public int totalRestaurantes(){ 
        return this.restaurantes.size();
    }
    public void add(Restaurante restaurante){
        restaurantes.add(restaurante);
    }

    @Override
    public Collection<String> locais() {
        Collection<String> dinner = new ArrayList<>();
        for (Restaurante restaurante : restaurantes){
            dinner.add(restaurante.toString());
        }
        return dinner;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((restaurantes == null) ? 0 : restaurantes.hashCode());
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
        Gastronomia other = (Gastronomia) obj;
        if (restaurantes == null) {
            if (other.restaurantes != null)
                return false;
        } else if (!restaurantes.equals(other.restaurantes))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Gastronomia [restaurantes=" + restaurantes + "]";
    }
    
    
    
}
