package aula09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import aula07.DateYMD;

public class Aldemo {
    public static void main(String[] args) {

		
		ArrayList<Integer> c1 = new ArrayList<>();

		for (int i = 10; i <= 100; i += 10) {
            c1.add(i);
        }
			
		System.out.println("Size: " + c1.size());

		for (int i = 0; i < c1.size(); i++) {
            System.out.println("Elemento: " + c1.get(i));
        }	

		ArrayList<String> c2 = new ArrayList<>();
		c2.add("Vento");
		c2.add("Calor");
		c2.add("Frio");
		c2.add("Chuva");
		System.out.println(c2);
		Collections.sort(c2);
		System.out.println(c2);
		c2.remove("Frio");
		c2.remove(0);
		System.out.println(c2);

		System.out.println(c2.contains("Frio"));
		System.out.println(c2.lastIndexOf("Vento"));

		Set<Pessoa> c3 = new HashSet<>();
		c3.add(new Pessoa("Igor Santos", 8976543, new DateYMD(1124, 7, 15)));
		c3.add(new Pessoa("Marco Pinto", 9988776, new DateYMD(1821, 7, 6)));
		c3.add(new Pessoa("Ana Moreira", 8978549, new DateYMD(1111, 8, 5)));
		c3.add(new Pessoa("Maria Almeida", 8979590, new DateYMD(1272, 8, 18)));
		c3.add(new Pessoa("Alberto Costa", 8977790, new DateYMD(1022, 7, 19)));

		Iterator<Pessoa> i = c3.iterator();
		while (i.hasNext())
			System.out.println(i.next());

		Set<DateYMD> c4 = new TreeSet<>();
		c4.add(new DateYMD(1985, 7, 12));
		c4.add(new DateYMD(1890, 7, 1));
		c4.add(new DateYMD(1199, 8, 19));
		c4.add(new DateYMD(1500, 7, 15));
		c4.add(new DateYMD(1010, 7, 19));
		
		Iterator<DateYMD> j = c4.iterator();
        
		while (j.hasNext()) {
            System.out.println(j.next());
        }	
	}
}

///o construtor pessoa da aula 7 estava adaptado para a aula 7 e não para esta aula 