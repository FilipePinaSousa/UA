package viagens;

public class Aventura {
    private String name;
    private String description;
    private double price;
    private TipoServico type;

    public Aventura(String name, String description, double price) {
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

    @Override
    public String toString() {
        return "Aventura [name=" + name + ", description=" + description + ", price=" + price + ", type=" + type + "]";
    }
    

}
