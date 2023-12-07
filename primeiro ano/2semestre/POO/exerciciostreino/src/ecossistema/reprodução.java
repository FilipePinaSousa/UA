package ecossistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class reprodução {
    private ArrayList <String> erança;
    private HashMap <String,String > mesmaespecie;
    
    


    public reprodução(ArrayList<String> erança, HashMap<String,String> mesmaespecie) {
        this.erança = erança;
        this.mesmaespecie = mesmaespecie;
    }

    public ArrayList<String> getErança() {
        return this.erança;
    }

    public void setErança(ArrayList<String> erança) {
        this.erança = erança;
    }

    public HashMap<String,String> getMesmaespecie() {
        return this.mesmaespecie;
    }

    public void setMesmaespecie(HashMap<String,String> mesmaespecie) {
        this.mesmaespecie = mesmaespecie;
    }

    public reprodução erança(ArrayList<String> erança) {
        setErança(erança);
        return this;
    }

    public reprodução mesmaespecie(HashMap<String,String> mesmaespecie) {
        setMesmaespecie(mesmaespecie);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof reprodução)) {
            return false;
        }
        reprodução reprodução = (reprodução) o;
        return Objects.equals(erança, reprodução.erança) && Objects.equals(mesmaespecie, reprodução.mesmaespecie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(erança, mesmaespecie);
    }

    @Override
    public String toString() {
        return "{" +
            " erança='" + getErança() + "'" +
            ", mesmaespecie='" + getMesmaespecie() + "'" +
            "}";
    }
}