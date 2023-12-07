package viagens2;

public class Restaurante {
    String nome;
    TipoComida tipocomida;
    public Restaurante(String nome, TipoComida tipocomida) {
        this.nome = nome;
        this.tipocomida = tipocomida;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public TipoComida getTipocomida() {
        return tipocomida;
    }
    public void setTipocomida(TipoComida tipocomida) {
        this.tipocomida = tipocomida;
    }




    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((tipocomida == null) ? 0 : tipocomida.hashCode());
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
        Restaurante other = (Restaurante) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (tipocomida != other.tipocomida)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Restaurante [nome=" + nome + ", tipocomida=" + tipocomida + "]";
    }
    
}
