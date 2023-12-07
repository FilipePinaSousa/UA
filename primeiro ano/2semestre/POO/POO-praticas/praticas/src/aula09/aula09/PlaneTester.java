package aula09;

import java.util.Scanner;

public class PlaneTester {
    public static void main(String[] args) {
        PlaneManager planeManager = new PlaneManager();
        try (Scanner scanner = new Scanner(System.in)) {
            int choice = 0;
            
            while (choice != 7) {
                System.out.println("Selecione uma opção:");
                System.out.println("1. Adicionar avião à frota");
                System.out.println("2. Remover avião da frota");
                System.out.println("3. Procurar avião por ID");
                System.out.println("4. Imprimir informações de todos os aviões");
                System.out.println("5. Imprimir lista de aviões comerciais ou militares");
                System.out.println("6. Imprimir informações do avião mais rápido");
                System.out.println("7. Sair");
                System.out.print("Digite sua escolha: ");
                
                choice = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (choice) {
                    case 1:
                    // Adicionar avião comercial
                    System.out.print("Qual o tipo de avião:Comercial/Militar? ");
                    String tipo = scanner.nextLine();
                    if (tipo.equals("Comercial")) {
                        System.out.print("Digite o ID do avião comercial: ");
                        String id = scanner.nextLine();
                        System.out.print("Digite o fabricante do avião comercial: ");
                        String manufacturer = scanner.nextLine();
                        System.out.print("Digite o modelo do avião comercial: ");
                        String model = scanner.nextLine();
                        System.out.print("Digite o ano de fabricação do avião comercial: ");
                        int year = scanner.nextInt();
                        System.out.print("Digite a velocidade máxima do avião comercial: ");
                        int maxSpeed = scanner.nextInt();
                        System.out.print("Digite o número de tripulantes do avião comercial: ");
                        int numOfCrewMembers = scanner.nextInt();
                        System.out.print("Digite o número máximo de passageiros do avião comercial: ");
                        int maxPassengers = scanner.nextInt();
                        scanner.nextLine(); 

                        CommercialPlane commercialPlane = new CommercialPlane(id, manufacturer, model, year, maxSpeed, numOfCrewMembers, maxPassengers);
                        planeManager.addPlane(commercialPlane);
                        System.out.println("Avião comercial adicionado à frota.");
                        break;
                    } else if (tipo.equals("Militar")) {
                        System.out.print("Digite o ID do avião militar: ");
                        String militaryId = scanner.nextLine();
                        System.out.print("Digite o fabricante do avião militar: ");
                        String militaryManufacturer = scanner.nextLine();
                        System.out.print("Digite o modelo do avião militar: ");
                        String militaryModel = scanner.nextLine();
                        System.out.print("Digite o ano de fabricação do avião militar: ");
                        int militaryYear = scanner.nextInt();
                        System.out.print("Digite a velocidade máxima do avião militar: ");
                        int militaryMaxSpeed = scanner.nextInt();
                        System.out.print("Digite o número máximo de passageiros do avião militar: ");
                        int militaryMaxPassengers = scanner.nextInt();
                        System.out.print("Digite o número de mísseis do avião militar: ");
                        int numMissiles = scanner.nextInt();
                        scanner.nextLine();

                        MilitaryPlane militaryPlane = new MilitaryPlane(militaryId, militaryManufacturer, militaryModel, militaryYear, militaryMaxSpeed, militaryMaxPassengers, numMissiles);
                        planeManager.addPlane(militaryPlane);
                        System.out.println("Avião militar adicionado à frota.");
                        break;
                    }

                    case 2:
                        // Remover avião da frota
                        System.out.print("Digite o ID do avião a ser removido: ");
                        String removeId = scanner.nextLine();
                        planeManager.removePlane(removeId);
                        System.out.println("Avião removido da frota.");
                        break;
                    case 3:
                        // Procurar avião por ID
                        System.out.print("Digite o ID do avião a ser procurado: ");
                        String searchId = scanner.nextLine();
                        Plane searchedPlane = planeManager.searchPlane(searchId);
                        if (searchedPlane != null) {
                            System.out.println("Informações do avião encontrado:");
                            System.out.println(searchedPlane.toString());
                        } else {
                            System.out.println("Avião não encontrado na frota.");
                        }
                        break;
                    case 4:
                        // Imprimir informações de todos os aviões
                        System.out.println("Informações de todos os aviões na frota:");
                        planeManager.printAllPlanes();
                        break;
                    case 5:
                        // Imprimir lista de aviões comerciais ou militares
                        System.out.println("Selecione uma opção:");
                        System.out.println("1. Imprimir lista de aviões comerciais");
                        System.out.println("2. Imprimir lista de aviões militares");
                        System.out.print("Digite sua escolha: ");
                        int option = scanner.nextInt();
                        scanner.nextLine(); // Limpa o buffer do scanner
                        
                        if (option == 1) {
                            System.out.println("Lista de aviões comerciais na frota:");
                            planeManager.printCommercialPlanes();
                        } else if (option == 2) {
                            System.out.println("Lista de aviões militares na frota:");
                            planeManager.printMilitaryPlanes();
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;
                    case 6:
                        // Imprimir informações do avião mais rápido
                        Plane fastestPlane = planeManager.getFastestPlane();
                        if (fastestPlane != null) {
                            System.out.println("Informações do avião mais rápido:");
                            System.out.println(fastestPlane.toString());
                        } else {
                            System.out.println("Nenhum avião encontrado na frota.");
                        }
                        break;
                    case 7:
                        // Sair do programa
                        System.out.println("Encerrando o programa...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida.");
                    break;
                }
            }
        }
    }
}
                

                
                
                




