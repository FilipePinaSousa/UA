package aula04;

public class circulo {
    public double raio;

    public void setRaio(double raio) {
        if (valid(raio)) {
            this.raio = raio;
        } else {
            System.out.println("Introduza valores válidos!!");
        }
    }

    public boolean valid(double raio) {
        boolean retVal = false;
        if (raio > 0) {
            retVal = true;
        }
        return retVal;
    }

    public double calcularArea(double raio) {
        double area = Math.PI * Math.pow(raio, 2);
        return area;
    }

    public double calcularPerimetro(double raio) {
        double perimetro = 2 * Math.PI * raio;
        return perimetro;
    }

    public double getArea(double raio) {
        return calcularArea(raio);
    }

    public double getPerimetro(double raio) {
        return calcularPerimetro(raio);
    }
}
