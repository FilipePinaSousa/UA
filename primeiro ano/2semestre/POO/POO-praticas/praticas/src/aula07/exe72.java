package aula07;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class exe72 {
    public static void main(String[] args){
        
        int opt;
        Date data = null;
        
        Scanner sc= new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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
                    System.out.println("Digite a data no formato dd/MM/yyyy:");
                    String inputDate = sc.next();
                    try {
                        data = sdf.parse(inputDate);
                    } catch (ParseException e) {
                        System.out.println("Data inválida!");
                    }
                    break;
                case 2:
                    System.out.println("Data: "+ sdf.format(data));
                    break;
                case 3:
                    long time = data.getTime();
                    time += 24 * 60 * 60 * 1000; // Adiciona um dia em milissegundos
                    data.setTime(time);
                    System.out.println(sdf.format(data));
                    break;
                case 4:
                    time = data.getTime();
                    time -= 24 * 60 * 60 * 1000; // Subtrai um dia em milissegundos
                    data.setTime(time);
                    System.out.println(sdf.format(data));
                    break;
                default:
                    System.out.println("Escolha uma opção válida!");
                    break;
            }
        } while(opt!=0);

        sc.close();
    }
}
