package testeanopassado;
public class Catering extends Activity {
    private Catering.Option opcao;

    public Catering(Catering.Option opcao, int numeroParticipantes) {
        setNumeroParticipantes(numeroParticipantes);
        setPreçoUnico(25);
        this.opcao = opcao;
        setModal(String.valueOf(opcao));
        setTipo("Catering");
    }

    public Catering.Option getOpcao() {
        return opcao;
    }

    public void setOpcao(Catering.Option opcao) {
        this.opcao = opcao;
    }

    public enum Option{
        FULL_MENU,DRINKS_AND_SNACKS,LIGHT_BITES
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((opcao == null) ? 0 : opcao.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Catering other = (Catering) obj;
        if (opcao != other.opcao)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Catering [opcao=" + opcao + "]";
    }

    
    
}
