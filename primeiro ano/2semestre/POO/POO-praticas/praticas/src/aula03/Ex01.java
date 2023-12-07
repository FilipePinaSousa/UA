package aula03;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        do {
            System.out.print("Digite um número inteiro positivo: ");
            n = sc.nextInt();
        } while (n <= 0);
        int soma = 0;
        for (int i = 2; i <= n; i++) {
            if (ehPrimo(i)) {
                soma += i;
            }
        }
        System.out.println("A soma dos numeros primos até " + n + " é " + soma);
        sc.close();
    }

    public static boolean ehPrimo(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
