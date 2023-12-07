package aula10;

import java.util.HashMap;
import java.util.List;

public class genero {
    private String genero;

    HashMap<String,List<livro>> generos = new HashMap<>();

    public  genero(String genero){
        this.genero=genero;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero=genero;
    }

    public String toString() {
        return String.format("%s", genero);
    }

    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null || this.getClass()!=obj.getClass()){
            return false;
        }
        genero other=(genero) obj;
        return this.genero.equals(other.genero);
    }

  

    public int compareTo(genero other){
        return this.genero.compareTo(other.genero);
    }


}
