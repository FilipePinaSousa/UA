package aula07;

public class circulo extends forma {

    private double raio;
    public circulo(double raio, String cor) {
        super(cor);
        this.raio = raio;
    }

    public double perimetro() {
        return 2 * 3.14 * raio;
    }

    public double area() {
        return 3.14 * raio * raio;
    }
}