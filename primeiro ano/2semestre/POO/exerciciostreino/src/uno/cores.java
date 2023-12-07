package uno;

public class cores {
    private String color;
    protected String nextcolor;
    protected String actualcolor;
    
    public cores(String color){
        this.color = color;
    }
    public String getcolor(){
        return color;
    }
    public void setcolor(String color){
        this.color = color;
    }
    public String getnextcolor(){
        return nextcolor;
    }
    public void setnextcolor(String color){
        this.nextcolor = color;
    }
    public String getactualcolor(){
        return actualcolor;
    }
    public void setactualcolor(String color){
        this.actualcolor = color;
    }





    public enum asquatrocores(){
         Vermelho;
         verde;
         amarelo;
         Azul;
    }
    public Boolean samecolor(asqquadrocores){
        if (actualcolor == nextcolor){
            return True;
        }else{
            return False;
        }
    }

}