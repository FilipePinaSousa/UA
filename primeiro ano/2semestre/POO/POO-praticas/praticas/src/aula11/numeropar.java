package aula11;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class numeropar {
	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(new FileReader("major.txt"));
		input.useDelimiter("[\\p{Punct}\\s]+");
		ArrayList<String> words = new ArrayList<>();
		HashMap<String, HashMap<String, Integer>> pairs = new HashMap<>();
		while (input.hasNext()) {
			String word = input.next();
			if(word.length()>2) {
				words.add(word);
			}
		}
		for(int i=0;i<words.size()-1;i++) {
			String current = words.get(i);
			String next = words.get(i+1);
			if(!pairs.containsKey(current)) {
				HashMap<String, Integer> mapa = new HashMap<>();
				mapa.put(next, 1);
				pairs.put(current, mapa);
			}else {
				if(pairs.get(current).containsKey(next)) {
					pairs.get(current).replace(next, pairs.get(current).get(next) , pairs.get(current).get(next)+1);
				} else {
					pairs.get(current).put(next, 1);
				}
			}
		}
		input.close();
			
		for(int i = 0; i < pairs.size(); i++) {
			System.out.println(pairs.entrySet().toArray()[i].toString());
			
		}
	}
}

