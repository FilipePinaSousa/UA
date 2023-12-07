package ecossistema;

// Classe abstrata Organismo
public abstract class Organismo {
    private String nome;
    private int idade;
    private String localizacao;

    // Construtor
    public Organismo(String nome, int idade, String localizacao) {
        this.nome = nome;
        this.idade = idade;
        this.localizacao = localizacao;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    // Métodos específicos para cada organismo
    public abstract void realizarAcao();

    public void adicionarPresa(Organismo presa) {
    }

    public void adicionarPredador(Organismo predador) {
    }
}
