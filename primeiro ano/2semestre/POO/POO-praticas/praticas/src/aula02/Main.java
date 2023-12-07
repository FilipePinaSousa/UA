
package aula02;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double num, sum = 0, max = Double.NEGATIVE_INFINITY, min = Double.POSITIVE_INFINITY;
        int count = 0;

        System.out.print("Digite um número: ");
        num = input.nextDouble();

        while (num != 0) {
            count++;
            sum += num;

            if (num > max) {
                max = num;
            }

            if (num < min) {
                min = num;
            }

            System.out.print("Digite outro número (ou 0 para sair): ");
            num = input.nextDouble();
        }

        if (count == 0) {
            System.out.println("Nenhum número foi digitado!");
        } else {
            double average = sum / count;

            System.out.println("O valor máximo é: " + max);
            System.out.println("O valor mínimo é: " + min);
            System.out.println("A média dos números é: " + average);
            System.out.println("O total de números lidos é: " + count);
        }

        input.close();
    }
}
