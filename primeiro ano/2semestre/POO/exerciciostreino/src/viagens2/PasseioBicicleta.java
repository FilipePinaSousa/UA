package viagens2;

import java.util.ArrayList;
import java.util.Collection;

public class PasseioBicicleta extends Atividade{
    String[] locais = new String[10];

    
    public PasseioBicicleta(int identificador, String nome) {
        super(identificador, nome);
    }

    public PasseioBicicleta(int identificador, String nome, String[] locais) {
        super(identificador, nome);
        this.locais = locais;
    }

    public void addLocal(String local){
        ArrayList<String> novolocais = new ArrayList<>();
        String[] localFinal = new String[10];
        for(String sitio : locais){
            novolocais.add(sitio);
        }
        novolocais.add(local);

    }


    public String[] getLocais() {
        return locais;
    }

    public void setLocais(String[] locais) {
        this.locais = locais;
    }

    @Override
    public Collection<String> locais() {
        Collection<String> place = new ArrayList<>();
        for (String local : locais){
            place.add(local);
        }
        return place;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((locais == null) ? 0 : locais.hashCode());
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
        PasseioBicicleta other = (PasseioBicicleta) obj;
        if (locais == null) {
            if (other.locais != null)
                return false;
        } else if (!locais.equals(other.locais))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PasseioBicicleta [locais=" + locais + "]";
    }

    
    
}
