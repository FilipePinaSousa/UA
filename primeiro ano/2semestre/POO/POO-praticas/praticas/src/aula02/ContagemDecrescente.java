package aula02;

import java.util.Scanner;

public class ContagemDecrescente {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número positivo: ");
        int n = scanner.nextInt();
        scanner.close();
        
        for (int i = n; i >= 0; i--) {
            System.out.print(i);
            
            if (i % 10 == 0) {
                System.out.println();
            } else {
                System.out.print(", ");
            }
        }
    }
}
