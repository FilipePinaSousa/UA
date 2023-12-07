package viagens;

public class PacoteServicos {

    
    private String name;
    private String description;
    private double price;
    private TipoServico type;

    public PacoteServicos(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public double price() {
        return price;
    }

    public TipoServico type() {
        return type;
    }

    public PacoteServicos(String string, String string2) {

        return;

    }

    public void add(Servico selecionarServico) {
        return ;
    }

    public void add(Transporte transporte) {
    }

}
