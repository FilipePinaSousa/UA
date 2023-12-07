package aula2;
public class Main {
    public static void main(String[] args) {
        int number = UserInput.getIntWithinRange("Please enter a number between 1 and 10", 1, 10);
        switch (number) {
            case 1:
                System.out.println("You entered one.");
                break;
            case 2:
                System.out.println("You entered two.");
                break;
            case 3:
                System.out.println("You entered three.");
                break;
            case 4:
                System.out.println("You entered four.");
                break;
            case 5:
                System.out.println("You entered five.");
                break;
            case 6:
                System.out.println("You entered six.");
                break;
            case 7:
                System.out.println("You entered seven.");
                break;
            case 8:
                System.out.println("You entered eight.");
                break;
            case 9:
                System.out.println("You entered nine.");
                break;
            case 10:
                System.out.println("You entered ten.");
                break;
            default:
                break;
        }
    }
}
