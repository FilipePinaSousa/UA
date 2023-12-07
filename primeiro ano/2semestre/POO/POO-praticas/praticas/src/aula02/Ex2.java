package aula02;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduzs os Graus C°: ");
        double c = sc.nextDouble();
        double f = 1.8*c + 32;
        System.out.print(c + " graus C° = " + f + " graus F°");

        sc.close();
    }
}
