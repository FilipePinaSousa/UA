package Campismo;
import java.util.Objects;
public class TentSpace extends CampingSpace {

    public TentSpace(  String localização, int[] dimensões, int preçopordia, int maximoaluger) {
        super();
    }

    public TentSpace(String string, int[] is, int i) {
    }

public int Maximodias() {
    maximoaluger = 15;
return this.maximoaluger;


}

    public TentSpace() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TentSpace)) {
            return false;
        }
        TentSpace tentSpace = (TentSpace) o;
        return Objects.equals(this, tentSpace);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "{" +
            "}";
    }


}