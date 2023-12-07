package aula07;

public abstract class forma {
    protected String cor;

    public forma(String cor) {
        this.cor = cor;
    }

    public abstract double perimetro();
    public abstract double area();
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}

