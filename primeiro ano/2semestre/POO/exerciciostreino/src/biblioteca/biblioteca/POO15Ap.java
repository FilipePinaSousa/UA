package biblioteca;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class POO15Ap {
	
	public static void main(String[] args) {
		POO15Ap ap = new POO15Ap();
		ap.alinea1();
		ap.alinea2();
		}
	
	public void alinea1() {
		Biblioteca bAveiro = new Biblioteca("Biblioteca Municipal de Aveiro","Largo Dr. Jaime Magalhães Lima, 3800 - 156 Aveiro, Portugal");
		bAveiro.add(new Livro("História da Europa", "Lisboa: Dom Quixote", "Jean-Baptiste Duroselle", "972-20-0824-2"));
		bAveiro.add(new Livro("Papillon", "Amadora: Bertrand", "Henri Charrière"));
		bAveiro.add(new Livro("Branca de neve e os sete anões", "Abril Morumbi", "Jacob Grimm; Wilhelm Grimm"));
		bAveiro.add(new Revista("Revista municipal", "Aveiro: C.M.A.", "0874-727X"));
		bAveiro.add(new Jornal("Diário de notícias", Ver.CORES));
		Jornal gaf = new Jornal ("O gafanhoto");
		gaf.setPeriodicidade(Periodicidade.BIMESTRAL);
		bAveiro.add(gaf);
		System.out.println(bAveiro);
		// imprime todas as publicações da biblioteca
		try {
		PrintWriter fl = new PrintWriter(new File("output.txt"));
		fl.println(bAveiro);
		fl.close();
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		}
		}
	
	public void alinea2(){
		Map <String,Integer> editoras = new HashMap<String,Integer>();
		int i=0;
		String x;
		Scanner sfc =null;
		File in = new File("samples.txt");
		try{
			sfc = new Scanner(in);
			while(sfc.hasNext()){
				String[] array = sfc.nextLine().split("\t");
				if(array[0]!="Tipo"){
					if(array[2].contains(":"))
						x=array[2].split(":")[1].trim();
					else{
						x=array[2].trim();
					}
				if(editoras.containsKey(x)){
					i= editoras.get(x);
					i=i+1;
					editoras.put(x, i);
				}
				
				else{
					editoras.put(x, 1);
				}
				}							
			}
		}catch(FileNotFoundException e){
			System.out.println("Ficheiro Inexistente!");
		}
		
		System.out.println(editoras);

		
	}

}
