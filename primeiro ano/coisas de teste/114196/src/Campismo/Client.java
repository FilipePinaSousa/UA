package Campismo;
import java.util.Objects;
public class Client {
    private String name;
    private int nif;
    public static Client getClient(int taxId) {
        return null;
    }
    public static boolean registerClient(int taxId, String name2, Client type) {
        return false;
    }

    public Client() {
    }

    public Client(String name, int nif) {
        this.name = name;
        this.nif = nif;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNif() {
        return this.nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public Client name(String name) {
        setName(name);
        return this;
    }

    public Client nif(int nif) {
        setNif(nif);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Client)) {
            return false;
        }
        Client client = (Client) o;
        return Objects.equals(name, client.name) && nif == client.nif;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nif);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", nif='" + getNif() + "'" +
            "}";
    }
    
}