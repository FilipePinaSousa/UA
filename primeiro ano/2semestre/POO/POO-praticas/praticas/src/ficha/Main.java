package ficha;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fighter[] figthers = new Fighter[10];

        int choice = 0;
        do {
            System.out.println("Game menu:");
            System.out.println("1. Generate fighters");
            System.out.println("2. Show all fighters");
            System.out.println("3. Start fight between selected fighters");
            System.out.println("4. Start fight between random fighters");
            System.out.println("5. Exit");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // generate fighters and insert in array
                    for (int i = 0; i < figthers.length; i++) {
                        
                        // Number between 1 and 2 for type
                        int type = (int) (Math.random() * 2) + 1;

                        if (figthers[i] == null) {
                            if (type == 1) {
                                figthers[i] = new Boxer(String.valueOf(i));
                            } else if (type == 2) {
                                figthers[i] = new Wrestler(String.valueOf(i));
                            }
                        }
                    }
                    System.out.println("Fighters created!");

                    break;

                case 2:
                    // show fighters
                    // if array empty show message
                    if (figthers[0] == null) {
                        System.out.println("No fighters created!");
                        break;
                    }

                    System.out.println("\nFighters:\n");
                    for (int i = 0; i < figthers.length; i++) {
                        if (figthers[i] != null) {
                            System.out.println("Fighter " + i + "\n" + figthers[i]);
                        }
                    }

                    break;
                case 3:
                    if (figthers[0] == null) {
                        System.out.println("No fighters created!");
                        break;
                    }

                    //simulate a fight between selected fighters
                    System.out.print("Select first fighter: ");
                    int fighter1 = scanner.nextInt();

                    System.out.print("Select second fighter: ");
                    int fighter2 = scanner.nextInt();

                    while (figthers[fighter1].isAlive() && figthers[fighter2].isAlive()) {
                        // Escolher quem ataca
                        int attack = (int) (Math.random() * 2) + 1;

                        if (attack == 1) {
                            figthers[fighter1].attack(figthers[fighter2]);
                        } else {
                            figthers[fighter2].attack(figthers[fighter1]);
                        }
                    }

                    if(!figthers[fighter1].isAlive()){
                        // Se o fighter1 perder toda a vida perde o combate
                        System.out.println(figthers[fighter1].getName() + " is defeated!");
                        System.out.println(figthers[fighter2].getName() + " is the winner!");
                        figthers[fighter1].lose();
                        figthers[fighter2].win();

                    }else if (!figthers[fighter2].isAlive()){

                        System.out.println(figthers[fighter2].getName() + " is defeated!");
                        System.out.println(figthers[fighter1].getName() + " is the winner!");
                        figthers[fighter2].lose();
                        figthers[fighter1].win();
                    }

                    // set both fighters to full health
                    figthers[fighter1].setHealth(100);
                    figthers[fighter2].setHealth(100);


                    break;
                
                case 4:
                    if (figthers[0] == null) {
                        System.out.println("No fighters created!");
                        break;
                    }

                    //simulate a fight between random fighters
                    int fighter1Random = (int) (Math.random() * 10);
                    int fighter2Random = fighter1Random;
                    do{
                        fighter2Random = (int) (Math.random() * 10);
                    }while(fighter1Random == fighter2Random);
                    System.out.println("Luta entre: " + figthers[fighter1Random].getName() + " e " + figthers[fighter2Random].getName());

                    while (figthers[fighter1Random].isAlive() && figthers[fighter2Random].isAlive()) {
                        int attack = (int) (Math.random() * 2) + 1;

                        if (attack == 1) {
                            figthers[fighter1Random].attack(figthers[fighter2Random]);
                        } else {
                            figthers[fighter2Random].attack(figthers[fighter1Random]);
                        }
                    }

                    if(!figthers[fighter1Random].isAlive()){
                        // Se o fighter1 perder toda a vida perde o combate
                        System.out.println(figthers[fighter1Random].getName() + " is defeated!");
                        System.out.println(figthers[fighter2Random].getName() + " is the winner!");
                        figthers[fighter1Random].lose();
                        figthers[fighter2Random].win();

                    }else if (!figthers[fighter2Random].isAlive()){

                        System.out.println(figthers[fighter2Random].getName() + " is defeated!");
                        System.out.println(figthers[fighter1Random].getName() + " is the winner!");
                        figthers[fighter2Random].lose();
                        figthers[fighter1Random].win();
                    }
                    // set both fighters to full health
                    figthers[fighter1Random].setHealth(100);
                    figthers[fighter2Random].setHealth(100);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Opção não existe!");
                    break;
            }

        } while (choice != 5);

        scanner.close();
    }
}
