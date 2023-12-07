package uno;




import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;




public class jogo {
    private int numcartasinicial;
    private String corinicial;
    private LinkedList<StringBuffer> number = new ArrayList<>(LinkedList.asList(jogador1,jogador2,jogador3,jogador4));
    private String jogador1;
    private String jogador2;
    private String jogador3;
    private String jogador4;

    private int numcartasjogador1;
    private int numcartasjogador2;
    private int numcartasjogador3;
    private int numcartasjogador4;
    
    private String actualPlayer;

    public jogo( String jogador1,String jogador2,String jogador3,String jogador4 ,int numcartas, String corinicial, int numcartasjogador1, int numcartasjogador2, int numcartasjogador3, int numcartasjogador4, BuffedString order, String actualPlayer) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.jogador3 = jogador3;
        this.jogador4 = jogador4;
        this.numcartasinicial = numcartas;
        this.corinicial = corinicial;
        this.numcartasjogador1 = numcartasjogador1;
        this.numcartasjogador2 = numcartasjogador2;
        this.numcartasjogador3 = numcartasjogador3;
        this.numcartasjogador4 = numcartasjogador4;
        this.order = order;
        this.actualPlayer = actualPlayer;
    }


   
    public int getnumcartasinicial() {
        return numcartasinicial;
    }
    public void setnumcartasinicial(int numcartasinicial){
        this.numcartasinicial = numcartasinicial;
    }
    public String getcorinicial() {
        return corinicial;
    }

    public void setcorinicial(String corinicial) {
        this.corinicial = corinicial;
    }

    public String getjogador1() {
        return jogador1;
    }

    public void setjogador1(String jogador1) {
        this.jogador1 = jogador1;
    }

    public String getjogador2() {
        return jogador2;
    }

    public void setjogador2(String jogador2) {
        this.jogador2 = jogador2;
    }

    public String getjogador3() {
        return jogador3;
    }

    public void setjogador3(String jogador3) {
        this.jogador3 = jogador3;
    }

    public String getjogador4() {
        return jogador4;
    }

    public void setjogador4(String jogador4) {
        this.jogador4 = jogador4;
    }

    public int getnumcartasjogador1() {
        return numcartasjogador1;
    }
    public void setnumcartasjogador1(int numcartasjogador1){
        this.numcartasjogador1 = numcartasjogador1;
    }

    public int getnumcartasjogador2() {
        return numcartasjogador2;
    }
    public void setnumcartasjogador2(int numcartasjogador2){
        this.numcartasjogador2 = numcartasjogador2;
    }

    public int getnumcartasjogador3() {
        return numcartasjogador3;
    }
    public void setnumcartasjogador3(int numcartasjogador3){
        this.numcartasjogador3 = numcartasjogador3;
    }


    public int getnumcartasjogador4() {
        return numcartasjogador4;
    }

    public void setnumcartasjogador4(int numcartasjogador4) {
        this.numcartasjogador4 = numcartasjogador4;
    }

    public  getorder() {
        return order;
    }

    public void setorder(int order) {
        this.order = order;
    }

    public String getactualPlayer() {
        return actualPlayer;
    }

    public void setactualPlayer(String actualPlayer) {
        this.actualPlayer = actualPlayer;
    }

    public aceptablenextcard(){
            return samecolor || samenumber;
            

    }



    


    
}
