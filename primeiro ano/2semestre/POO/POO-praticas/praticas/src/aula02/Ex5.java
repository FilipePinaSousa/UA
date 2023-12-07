package aula02;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double v1, d1, v2, d2;
        System.out.print("Velocidade 1: ");
        v1 = sc.nextDouble();
        System.out.print("Distância 1: ");
        d1 = sc.nextDouble();
        System.out.print("Velocidade 2: ");
        v2 = sc.nextDouble();
        System.out.print("Distância 2: ");
        d2 = sc.nextDouble();
        double v = (v1*v2*(d1+d2))/(d1*v2+d2*v1);
        System.out.print("Velocidade média final: " + v);

        sc.close();
    }
}
