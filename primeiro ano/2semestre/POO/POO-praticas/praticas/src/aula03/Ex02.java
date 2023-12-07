package aula03;


import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = -1;
        double m = -1;

        do {    
            System.out.println("introduza o montante investido");
            n = sc.nextInt();
        }while(n < 0 || n % 1000 != 0 );
        do {
            System.out.println("introduza a taxa de juro mensal");
            m = sc.nextDouble();
        }while  (m < 0 || m > 5 );

        double saldo_mes = n; 
        for (int i = 1; i <= 12; i++) {
            double juros = saldo_mes * m / 100;
            saldo_mes += juros;
            String conta_do_mes = String.format("Mês %s: %.2f€", i, saldo_mes);
            System.out.println(conta_do_mes);
        }

        sc.close();
    }
}

