package viagens;

public class MundoRural {


    private String name;
    private String description;
    private double price;

    public MundoRural(String name, String description, int price) {
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

    @Override
    public String toString() {
        return "MundoRural [name=" + name + ", description=" + description + ", price=" + price + "]";
    }
    
}
