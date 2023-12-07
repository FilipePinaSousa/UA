package aula10;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class procuradorficheiro {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new FileReader("C:\\Users\\filip\\Desktop\\escolinha\\2semestre\\POO\\POO-praticas\\praticas\\src\\aula10\\words.txt"));
        ///este caminho e no caso onde se encontra o ficheiro

        List<String> words = new ArrayList<>();
        while (input.hasNext()) {
            String word = input.next();
            if (word.length() > 2) {
                words.add(word);
            }
        }
        System.out.println(words);
        for (String word : words) {
            if (word.charAt(word.length()-1) == 's') {
                System.out.println(word);
            }
        }
        List<String> cleanWords = new ArrayList<>();
        for (String word : words) {
            if (word.matches("[a-zA-Z]+")) {
                cleanWords.add(word);
            }
        }
        System.out.println(cleanWords);
    }
}
