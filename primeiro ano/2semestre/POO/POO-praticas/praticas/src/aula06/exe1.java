package aula06;
import aula05.DateYMD;



public class exe1 {
    public static void main(String[] args) {
   aluno al = new aluno ("Andreia Melo", 9855678,
    new DateYMD(18, 7, 1990), new DateYMD(1, 9, 2018));
   Professor p1 = new Professor("Jorge Almeida", new DateYMD(13, 3, 1967), 
   "Associado", "Informática");
   Bolseiro bls = new Bolseiro ("Igor Santos", 8976543, new DateYMD(11, 5, 1985), p1, 
   900);
   bls.setBolsa(1050);
   System.out.println("Aluno: " + al.getName());
   System.out.println(al);
    
   System.out.println("Bolseiro: " + bls.getName() + ", NMec: " 
   + bls.getNMec() + ", Bolsa: " + bls.getBolsa() + ", Orientador: " + 
   bls.getOrientador());
   System.out.println(bls);
    }
   } 
   



