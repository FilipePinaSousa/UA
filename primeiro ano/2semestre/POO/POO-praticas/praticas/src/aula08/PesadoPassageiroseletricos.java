package aula08;

public class PesadoPassageiroseletricos extends PesadoPassageiros implements VeiculoEletrico {
        int autonomia;
        Object carregar;
    public PesadoPassageiroseletricos(String matricula, String marca, String modelo, int cilindrada, int numQuadro,
            double peso, double numPassageiros) {
        super(matricula, marca, modelo, cilindrada, numQuadro, peso, numPassageiros);
    }

    @Override
    public int autonomia() {
        
        return autonomia;
    }

    @Override
    public Object carregar(int percentagem) {
        
        return carregar;
    }
    
}
