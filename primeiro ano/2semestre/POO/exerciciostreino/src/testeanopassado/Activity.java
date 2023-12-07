package testeanopassado;
public abstract class Activity {
    private int numeroParticipantes;
    private int preçoUnico;
    private String modal;
    private String tipo;
    public int getNumeroParticipantes() {
        return numeroParticipantes;
    }
    public void setNumeroParticipantes(int numeroParticipantes) {
        this.numeroParticipantes = numeroParticipantes;
    }
    public int getPreçoUnico() {
        return preçoUnico;
    }
    public void setPreçoUnico(int preçoUnico) {
        this.preçoUnico = preçoUnico;
    }

    public void setModal(String modal){
        this.modal = modal;
    }
    public String getModal(){
        return modal;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
