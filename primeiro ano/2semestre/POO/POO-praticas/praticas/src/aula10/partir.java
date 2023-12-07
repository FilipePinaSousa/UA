package aula10;
import java.util.HashMap;
public class partir {
        public static void main(String[] args) {
            String str = "Hello World";
            HashMap<Character, String> charPositions = new HashMap<Character, String>();
            
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (charPositions.containsKey(c)) {
                    String positions = charPositions.get(c);
                    positions += ", " + i;
                    charPositions.put(c, positions);
                } else {
                    charPositions.put(c, "[" + i + "]");
                }
            }
            
            System.out.println(charPositions);
        }
    }
    
    
    
        

