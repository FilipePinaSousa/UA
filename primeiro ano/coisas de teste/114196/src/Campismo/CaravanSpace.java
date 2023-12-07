package Campismo;
import java.util.HashMap;
import java.util.Objects;


public class CaravanSpace extends CampingSpace {


    public CaravanSpace(    String localização, int[] dimensões, int preçopordia) {
        super();
    }
    public @Override
    public int Maximodias() {
        maximoaluger = 3*30;
    return this.maximoaluger;

    }

    public CaravanSpace() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CaravanSpace)) {
            return false;
        }
        CaravanSpace caravanSpace = (CaravanSpace) o;
        return Objects.equals(this, caravanSpace);
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

