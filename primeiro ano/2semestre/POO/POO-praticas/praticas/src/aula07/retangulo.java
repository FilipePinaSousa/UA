package aula07;


public class retangulo extends forma {

    private double base;
    private double altura;

    public retangulo(double base, double altura, String cor) {
        super(cor);
        this.base = base;
        this.altura = altura;
    }

    public double perimetro() {
        return 2 * (base + altura);
    }

    public double area() {
        return base * altura;
    }
}
