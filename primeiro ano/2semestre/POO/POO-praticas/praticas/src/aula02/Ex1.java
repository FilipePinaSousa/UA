package aula02;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Distância em km: ");
        double km = sc.nextDouble();
        double mi = km/1.609;
        System.out.print("Equivale a  = " + mi +"milhas");

        sc.close();
    }
}
