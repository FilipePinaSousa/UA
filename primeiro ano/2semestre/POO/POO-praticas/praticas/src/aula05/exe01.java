package aula05;

import java.util.Scanner;

public class exe01 {
    public static void main(String[] args){
        
        int opt;
        DateYMD data = null; 
        
        Scanner sc= new Scanner(System.in);

        do{
            System.out.println();
            System.out.println("1 - Criar nova data");
            System.out.println("2 - Mostrar data atual");
            System.out.println("3 - Incrementar data");
            System.out.println("4 - Decrementar data");
            System.out.println("0 - Sair");
            System.out.println();
            System.out.print("Operação: ");
            opt=sc.nextInt();

            switch(opt){
                case 0:
                    System.out.println("Encerrando...");
                    break;
                case 1:
                    System.out.println("aplique a data desta forma DD/MM/YYYY");
                    String inputDate = sc.next();
                    String[] parts = inputDate.split("/");
                    int day = Integer.parseInt(parts[0]);
                    int month = Integer.parseInt(parts[1]);
                    int year = Integer.parseInt(parts[2]);
                    data = new DateYMD(year, month, day); 
                    break;
                case 2:
                    System.out.println("Data: "+ data);
                    break;
                case 3:
                    data.increment();
                    System.out.println(data);
                    break;
                case 4:
                    data.decrement();
                    System.out.println(data);
                    break;
                default:
                    System.out.println("Escolha uma opção válida!");
                    break;
            }
        } while(opt!=0);

        sc.close();
    }
}
