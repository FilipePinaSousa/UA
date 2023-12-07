package viagens2;

public class Organizacao {
    String contactotelefone;

    public Organizacao(String contactotelefone) {
        this.contactotelefone = contactotelefone;
    }

    public String getContactotelefone() {
        return contactotelefone;
    }

    public void setContactotelefone(String contactotelefone) {
        this.contactotelefone = contactotelefone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contactotelefone == null) ? 0 : contactotelefone.hashCode());
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
        Organizacao other = (Organizacao) obj;
        if (contactotelefone == null) {
            if (other.contactotelefone != null)
                return false;
        } else if (!contactotelefone.equals(other.contactotelefone))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Organizacao [contactotelefone=" + contactotelefone + "]";
    }
}
