package testeanopassado;


public class Culture extends Activity {
    private Culture.Option opcao;

    public Culture(Culture.Option opcao, int numeroParticipantes) {
        setNumeroParticipantes(numeroParticipantes);
        setPreçoUnico(22);
        this.opcao = opcao;
        setModal(String.valueOf(opcao));
        setTipo("Culture");
    }

    public Culture.Option getOpcao() {
        return opcao;
    }

    public void setOpcao(Culture.Option opcao, int numeroParticipantes) {
        this.opcao = opcao;
    }

    public enum Option{
        ART_MUSEUM,ARCHITECTURAL_TOUR,RIVER_TOUR,WINE_TASTING

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
        Culture other = (Culture) obj;
        if (opcao != other.opcao)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Culture [opcao=" + opcao + "]";
    }

    
    
}
