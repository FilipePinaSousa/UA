package reconhecimentofacial;

public class Olhos extends Cara {
    private CorDeOlhos cor;

    public Olhos(CorDeOlhos cor) {
        this.cor = cor;
        
    }

    public CorDeOlhos getCor() {
        return cor;
    }
    
    public enum CorDeOlhos{
        Verde,
        Castanha,
        Azul

    }
    
    
}
