package reconhecimentofacial;
import java.util.Objects;

public class Cara extends Pessoa{
    public enum formato{
        OVAL,
        REDONDO
    }
    public enum cordocabelo{
        PRETO,
        CASTANHO,
        LOIRO,
        RUIVO,

    }    

    public getCara(){
        return Cara
        
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cara)) {
            return false;
        }
        Cara cara = (Cara) o;
        return Objects.equals(this, cara);
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
