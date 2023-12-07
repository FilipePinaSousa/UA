package aula02;

import java.util.Scanner;

public class Ex4 {
	
	static double calculo_montante(double montante_inicial, double taxa, int meses){   
																				
		double montante_final = montante_inicial;
		
		for(int i=1; i <= meses; i++) {
			montante_final += taxa*0.01*montante_final;
		}
		
		return montante_final;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);												
		
		System.out.print("Montante investido: ");
		double mi = sc.nextDouble();
		System.out.print("Taxa de juro mensal: ");			
		double tx = sc.nextDouble();
		System.out.print("Duração em meses da aplicação da taxa: ");
		int m = sc.nextInt();
		
		sc.close();																			
		
		double mf = calculo_montante(mi, tx, m);												
		System.out.print("Ao fim de " + m + " meses, o seu montante final será de: " + mf + " euros.");
	}

}
