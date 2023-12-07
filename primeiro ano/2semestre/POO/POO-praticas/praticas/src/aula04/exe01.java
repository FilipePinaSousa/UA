package aula04;

import java.util.Scanner;

public class exe01 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        circulo circulo; 
        Triangulo triangulo;
        retangulo retangulo;

        int opcao = 0;
        while (opcao != 4) {
            System.out.println("Escolha uma forma geométrica para criar:");
            System.out.println("1 - Circulo");
            System.out.println("2 - Triangulo");
            System.out.println("3 - Retangulo");
            System.out.println("4 - Sair");

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o raio do circulo:");
                    double raioCirculo = input.nextDouble();
                    circulo = new circulo(); 
                    System.out.println(circulo.toString());
                    System.out.println("Area: " + circulo.calcularArea(raioCirculo));
                    System.out.println("Perimetro: " + circulo.calcularPerimetro(raioCirculo));
                    break;
                case 2:
                    System.out.println("Digite os lados do triangulo:");
                    double lado1Triangulo = input.nextDouble();
                    double lado2Triangulo = input.nextDouble();
                    double lado3Triangulo = input.nextDouble();
                    triangulo = new Triangulo(lado1Triangulo, lado2Triangulo, lado3Triangulo);
                    System.out.println(triangulo.toString());
                    System.out.println("Area: " + triangulo.calcularArea());
                    System.out.println("Perimetro: " + triangulo.calcularPerimetro());
                    break;
                case 3:
                    System.out.println("Digite a altura do retangulo:");
                    double alturaRetangulo = input.nextDouble();
                    System.out.println("Digite o comprimento do retangulo:");
                    double comprimentoRetangulo = input.nextDouble();
                    retangulo = new retangulo(alturaRetangulo, comprimentoRetangulo);
                    System.out.println(retangulo.toString());
                    System.out.println("Area: " + retangulo.calcularArea());
                    System.out.println("Perimetro: " + retangulo.calcularPerimetro());
                    break;
                case 4:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
                    break;
            }
        }

        input.close();
    }
}
