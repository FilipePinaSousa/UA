package aula07;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        ArrayList<forma> formas = new ArrayList<forma>();
        Scanner scanner = new Scanner(System.in);
        String cor = "";

        while (true) {
            System.out.println("Escolha uma forma:");
            System.out.println("1 - Círculo");
            System.out.println("2 - Triângulo");
            System.out.println("3 - Retângulo");
            System.out.println("4 - Listar formas");
            System.out.println("0 - Sair");
            int escolha = scanner.nextInt();

            if (escolha == 0) {
                break;
            }

            System.out.print("Digite a cor da forma: ");
            cor = scanner.next();

            if (escolha == 1) {
                System.out.print("Digite o raio do círculo: ");
                double raio = scanner.nextDouble();
                circulo c = new circulo(raio, cor);
                formas.add(c);
                System.out.printf("Área: %.2f Perímetro: %.2f\n", c.area(), c.perimetro());
            } else if (escolha == 2) {
                System.out.print("Digite a base do triângulo: ");
                double base = scanner.nextDouble();
                System.out.print("Digite a altura do triângulo: ");
                double altura = scanner.nextDouble();
                Triangulo t = new Triangulo(base, altura, altura, cor);
                formas.add(t);
                System.out.printf("Área: %.2f Perímetro: %.2f\n", t.area(), t.perimetro());
            } else if (escolha == 3) {
                System.out.print("Digite a base do retângulo: ");
                double base = scanner.nextDouble();
                System.out.print("Digite a altura do retângulo: ");
                double altura = scanner.nextDouble();
                retangulo r = new retangulo(base, altura, cor);
                formas.add(r);
                System.out.printf("Área: %.2f Perímetro: %.2f\n", r.area(), r.perimetro());
            } else if (escolha == 4) {
                for (forma f : formas) {
                    System.out.printf("Cor: %s Área: %.2f Perímetro: %.2f", f.getCor(), f.area(), f.perimetro());
                }
            }

        }
        scanner.close();
    }
}

