package aula03;

import java.util.Scanner;
public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

		int random;
		int numero;
		int tentativas;
		String resposta;
		
		do {
			tentativas = 0;
			random = (int) Math.round(Math.random() * 100);
			do {	
				System.out.print("Número entre 1 e 100: ");
				numero = sc.nextInt();
				tentativas++;
				
				if (numero > random) {
					System.out.println("Alto");
				} else if (numero < random) {
					System.out.println("Baixo");
				}	
			} while (numero != random); 
			
			System.out.println("Acertou!");
            System.out.println("Usou " + tentativas + " tentativas.");
			System.out.println("Pretende continuar? Prima (S)im");
			resposta = sc.next();
			
		} while (resposta.toUpperCase().equals("S") || resposta.toUpperCase().equals("SIM"));
		
		System.out.println("Jogo terminado");

        sc.close();
	}
}
