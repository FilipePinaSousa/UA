package temperatura;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class TemperaturaTester {
    private TemperaturaManager temperaturaManager;

   
    public static void main(String[] args) {
        TemperaturaTester tester = new TemperaturaTester();
        tester.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Localidade localidade = null; // Default initialization

        System.out.println("Digite o número da opção desejada: ");
        System.out.println("1 - Ler arquivo de temperaturas");
        System.out.println("2 - Listar todas as temperaturas registradas");
        System.out.println("3 - Listar todas as localidades registradas");
        System.out.println("4 - Listar a temperatura média de uma localidade");
        System.out.println("5 - Listar a temperatura média de todas as localidades");
        System.out.println("6 - Listar a maior temperatura registrada");
        System.out.println("7 - Listar a menor temperatura registrada");
        System.out.println("0 - Sair");

        int opcao;
        do {
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o caminho do arquivo: ");
                    String filePath = scanner.next();
                    loadFile(filePath);
                    break;
                case 2:
                    temperaturaManager.showAllTemperaturas();
                    break;
                case 3:
                    temperaturaManager.showAllLocalidades();
                    break;
                case 4:
                    System.out.println("Digite o nome da localidade: ");
                    String nomeLocalidade = scanner.next();
                    localidade = new Localidade(nomeLocalidade);
                    double temperaturaMedia = temperaturaManager.temperaturaMediaLocalidade(localidade);
                    System.out.println("Temperatura média de " + nomeLocalidade + ": " + temperaturaMedia);
                    break;
                
                case 5:
                    double temperaturaMediaTodas = temperaturaManager.temperaturaMediaTodasLocalidades();
                    System.out.println("Temperatura média de todas as localidades: " + temperaturaMediaTodas);
                    break;
                case 6:
                    double maiorTemperatura = temperaturaManager.maiorTemperatura(localidade);
                    System.out.println("Maior temperatura registrada: " + maiorTemperatura);
                    break;
                case 7:
                    double menorTemperatura = temperaturaManager.menorTemperatura(localidade);
                    System.out.println("Menor temperatura registrada: " + menorTemperatura);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }




    public void loadFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                String localidade = parts[0];
                String data = parts[1];
                String temperatura = parts[2];
                System.out.println(localidade + " " + data + " " + temperatura);
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo");
        }
    }

    



}