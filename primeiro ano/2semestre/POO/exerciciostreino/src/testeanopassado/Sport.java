package testeanopassado;
public class Sport extends Activity {
    private Sport.Modality modalidade;
    public Sport(Sport.Modality modalidade, int numeroParticipantes ) {
        setNumeroParticipantes(numeroParticipantes);
        setPreçoUnico(30);
        this.modalidade= modalidade;
        setModal(String.valueOf(modalidade));
        setTipo("Sport");

    }

    


    public Sport.Modality getModalidade() {
        return modalidade;
    }

    public void setModalidade(Sport.Modality modalidade) {
        this.modalidade = modalidade;
    }

    public enum Modality {
        KAYAK,BIKE
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((modalidade == null) ? 0 : modalidade.hashCode());
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
        Sport other = (Sport) obj;
        if (modalidade != other.modalidade)
            return false;
        return true;
    }




    @Override
    public String toString() {
        return "Sport [modalidade=" + modalidade + "]";
    }

    
    
}

    
