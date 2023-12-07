package Campismo;
import java.util.Objects;
public class CarSpace extends CampingSpace {

    public CarSpace(String localização, int[] dimensões, int preçopordia ,int maximoaluger) {
        super();
    }



    public @Override
        public int Maximodias() {
            maximoaluger = 3*365;
        return this.maximoaluger;

    
        }

    public CarSpace(String string, int[] is, int i) {
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CarSpace)) {
            return false;
        }
        CarSpace carSpace = (CarSpace) o;
        return Objects.equals(this, carSpace);
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