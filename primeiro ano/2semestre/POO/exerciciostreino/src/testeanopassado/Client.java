package testeanopassado;
public class Client {
    private String nome;
    private String localidade;
    
    
    public Client(String nome, String localidade) {
        this.nome = nome;
        this.localidade = localidade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getLocalidade() {
        return localidade;
    }
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((localidade == null) ? 0 : localidade.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return getNome() + " ["+getLocalidade()+"]";
    }
    
    
}
