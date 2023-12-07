package temperatura;

import java.util.Objects;

public class Temperatura {
    private double temperatura;
    private Localidade localidade;


    public Temperatura() {
    }

    public Temperatura(double temperatura, Localidade localidade) {
        this.temperatura = temperatura;
        this.localidade = localidade;
    }

    public double getTemperatura() {
        return this.temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public Localidade getLocalidade() {
        return this.localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    public Temperatura temperatura(double temperatura) {
        setTemperatura(temperatura);
        return this;
    }

    public Temperatura localidade(Localidade localidade) {
        setLocalidade(localidade);
        return this;
    }
    

    @Override
    public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Temperatura that = (Temperatura) o;
    return Double.compare(that.temperatura, temperatura) == 0 &&
            Objects.equals(localidade, that.localidade);
}

    @Override
    public int hashCode() {
        return Objects.hash(temperatura, localidade);
    }

    @Override
    public String toString() {
        return "{" +
            " temperatura='" + getTemperatura() + "'" +
            ", localidade='" + getLocalidade() + "'" +
            "}";
    }

   
}
