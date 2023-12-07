package aula02;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double m, ti, tf;
        System.out.print("Quantidade de água em kg: ");
        m = sc.nextDouble();
        System.out.print("Temperatura inicial em graus C°: ");
        ti = sc.nextDouble();
        System.out.print("Temperatura final em graus C°: ");
        tf = sc.nextDouble();
        double q = m*(tf-ti)*4184;
        System.out.print("A energia necessária é de " + q + " Joules."); 

        sc.close();
    }
}
