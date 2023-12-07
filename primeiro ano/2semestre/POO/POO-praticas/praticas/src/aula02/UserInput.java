package aula02;
import java.util.Scanner;

public class UserInput {
    public static int getIntWithinRange(String prompt, int min, int max) {
        try (Scanner scanner = new Scanner(System.in)) {
            int input;
            boolean valid = false;
            do {
                System.out.print(prompt + " (" + min + " - " + max + "): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter an integer.");
                    scanner.next();
                }
                input = scanner.nextInt();
                if (input < min || input > max) {
                    System.out.println("Invalid input! Please enter an integer within the range.");
                } else {
                    valid = true;
                }
            } while (!valid);
            return input;
        }
    }
}
