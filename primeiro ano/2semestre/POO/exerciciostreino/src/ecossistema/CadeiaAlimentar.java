package ecossistema;

import java.util.ArrayList;
import java.util.List;

public class CadeiaAlimentar {
    private List<Organismo> organismos;

    public CadeiaAlimentar() {
        organismos = new ArrayList<>();
    }

    public void adicionarOrganismo(Organismo organismo) {
        organismos.add(organismo);
    }

    public void adicionarRelacaoAlimentar(Organismo predador, Organismo presa) {
        predador.adicionarPresa(presa);
        presa.adicionarPredador(predador);
    }

    // Métodos adicionais...

}
