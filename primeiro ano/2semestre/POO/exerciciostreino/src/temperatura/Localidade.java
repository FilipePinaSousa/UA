package temperatura;

import java.util.Date;
import java.util.Objects;

public class Localidade {
    private String Localidade;
    private java.util.Date data;

  
    public Localidade(String Localidade) {
        this.Localidade = Localidade;
    }

    public  String getLocalidade() {
        return Localidade;
    }

    public void setLocalidade(String Localidade) {
        this.Localidade = Localidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Localidade Localidade(String Localidade) {
        setLocalidade(Localidade);
        return this;
    }

    public Localidade data(Date data) {
        setData(data);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Localidade)) {
            return false;
        }
        Localidade localidade = (Localidade) o;
        return Objects.equals(Localidade, localidade.Localidade) && Objects.equals(data, localidade.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Localidade, data);
    }

    @Override
    public String toString() {
        return "{" +
            " Localidade='" + getLocalidade() + "'" +
            ", data='" + getData() + "'" +
            "}";
    }
    
    
}
