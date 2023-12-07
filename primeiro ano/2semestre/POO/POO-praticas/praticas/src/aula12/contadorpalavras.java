package aula12;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class contadorpalavras {
	public static void main(String[] args) throws IOException {
		Set<String> words = new HashSet<>();
		int cont = 0;
		
		Scanner input = new Scanner(new FileReader("biblia-em-txt.txt"));
		input.useDelimiter("[\\p{Punct}\\s]+");
		
		while(input.hasNext()) {
			String word = input.next();
			cont++;
			words.add(word);
		}
		input.close();
		System.out.println("Número Total de Palavras: "+cont);
		System.out.println("Número de Diferentes Palavras: "+words.size());
	}
}
