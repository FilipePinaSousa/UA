package aula06;
import aula05.DateYMD;
public class Bolseiro extends aluno {
    private static int contador = 100;
    private int nMec;
    private DateYMD iDataInsc;
    private Professor orientador;
    private int bolsa;

    public Bolseiro(String iNome, int nMec, DateYMD iDataInsc, Professor p1, int bolsa) {
        super(iNome, contador++, iDataInsc);
        this.iDataInsc = iDataInsc;
        this.orientador = p1;
        this.bolsa = bolsa;
    }

    public int getNMec() {
        return nMec;
    }

    public DateYMD getIDataInsc() {
        return iDataInsc;
    }

    public Professor getOrientador() {
        return orientador;
    }

    public int getBolsa() {
        return bolsa;

    }

    public void setBolsa(int bolsa) {
        this.bolsa = bolsa;
    }

    
    public String toString(){
        return "Nome" + super.getName() + ";CC" + super.getcc() + "Data de Nascimento"+ super.getDateNasc() + "Data de Inscrição" + getIDataInsc() + "Orientador" + getOrientador() + "Bolsa" + getBolsa();
    }


}
