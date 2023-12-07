package viagens2;

import java.util.ArrayList;

public class AgenciaTuristica {
    String nome, endereço;
    ArrayList<Atividade> conjuntoAtividades = new ArrayList<>();
    public AgenciaTuristica(String nome, String endereço, ArrayList<Atividade> conjuntoAtividades) {
        this.nome = nome;
        this.endereço = endereço;
        this.conjuntoAtividades = conjuntoAtividades;
    }
    public AgenciaTuristica(String nome, String endereço) {
        this.nome = nome;
        this.endereço = endereço;
    }
    public void add(Atividade atividade){
        conjuntoAtividades.add(atividade);
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereço() {
        return endereço;
    }
    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }
    public ArrayList<Atividade> getConjuntoAtividades() {
        return conjuntoAtividades;
    }
    public void setConjuntoAtividades(ArrayList<Atividade> conjuntoAtividades) {
        this.conjuntoAtividades = conjuntoAtividades;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((conjuntoAtividades == null) ? 0 : conjuntoAtividades.hashCode());
        result = prime * result + ((endereço == null) ? 0 : endereço.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
        AgenciaTuristica other = (AgenciaTuristica) obj;
        if (conjuntoAtividades == null) {
            if (other.conjuntoAtividades != null)
                return false;
        } else if (!conjuntoAtividades.equals(other.conjuntoAtividades))
            return false;
        if (endereço == null) {
            if (other.endereço != null)
                return false;
        } else if (!endereço.equals(other.endereço))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "AgenciaTuristica "
        + nome + "\nconjuntoAtividades=" + conjuntoAtividades + ", endereço=" + endereço + "]";
    }
    public String atividades(){
        return "conjuntoAtividades=" + conjuntoAtividades;
    }
    
    
}
