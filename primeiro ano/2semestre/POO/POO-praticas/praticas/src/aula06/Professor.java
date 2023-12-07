package aula06;
import aula05.DateYMD;
public class Professor extends Pessoa {
    private static String departamento;
    private static int contador = 100;
    private int nMec;
    private DateYMD iDataInsc;
    private String categoria;

    public Professor(String iNome, DateYMD iDataInsc, String categoria, String departamento) {
        super(iNome, contador++, iDataInsc);
        this.iDataInsc = iDataInsc;
        this.categoria = categoria;
        Professor.departamento = departamento;
        
        if (validateCategoria(categoria)) {
            this.categoria = categoria;
        } else {
            this.categoria = "Auxiliar";
        }
    }

    public static boolean validateCategoria(String categoria) {
        if(categoria.equals("Auxiliar") || categoria.equals("Associado") || categoria.equals("Catedrático")){
            return true;
        }
        return false;
    }

    public int getNMec() {
        return nMec;
    }

    public DateYMD getIDataInsc() {
        return iDataInsc;
    }

    public String getCategoria() {
        return categoria;
    }

    public static String getDepartamento() {
        return departamento;
    }

    public static void setDepartamento(String departamento) {
        Professor.departamento = departamento;
    }
}
