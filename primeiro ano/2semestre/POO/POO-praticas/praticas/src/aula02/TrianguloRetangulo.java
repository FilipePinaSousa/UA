package aula02;
import java.util.Scanner;

public class TrianguloRetangulo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double a, b, c, angulo;
        
        
        System.out.print("Digite o valor do cateto A: ");
        a = input.nextDouble();
        System.out.print("Digite o valor do cateto B: ");
        b = input.nextDouble();
        
        
        if (a <= 0 || b <= 0) {
            System.out.println("Os valores dos catetos devem ser positivos.");
            System.exit(0);
        }
        
        
        c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        System.out.println("O valor da hipotenusa é " + c);
        
        
        angulo = Math.toDegrees(Math.atan(b/a));
        System.out.println("O ângulo formado entre o lado A e a hipotenusa é " + angulo + " graus.");
        
        input.close();
    }
}
