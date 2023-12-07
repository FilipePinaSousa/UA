package aula08;


public class AutomovelLigeiroeletrico extends AutomovelLigeiro implements VeiculoEletrico {

    private int autonomia;
    private int carregar;

    public AutomovelLigeiroeletrico(String matricula, String marca, String modelo, int cilindrada, int numQuadro,
            int capBagageira) {
        super(matricula, marca, modelo, cilindrada, numQuadro, capBagageira);
    }

    @Override
    public int autonomia() {
        return autonomia;
    }

    @Override
    public  Object carregar(int percentagem) {
        return carregar;
    }
    
}
