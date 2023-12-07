package uno;


import java.util.LinkedList;
import java.util.List;

public class cartasdesoma extends cores {
    public cartasdesoma(String color) {
        super(color);
        //TODO Auto-generated constructor stub
    }
    private int maisdois = 2;
    private int maisquatro = 4;







    ////////////////////////////////////////////////////////////////////////////////////////
    private int numcartasjogador1;
    private int numcartasjogador2;
    private int numcartasjogador3;
    private int numcartasjogador4;
    private String actualPlayer;
    private String jogador1;
    private String jogador2;
    private String jogador3;
    private String jogador4;
    private List<String> number = new LinkedList<>();
////////////////////////////////////////////////////////////////////////////////////////
    

    public int getSomamaisdois() {
        return maisdois;
    }

    public int getSomamaisquatro() {
        return maisquatro;
    }

    public void setSomamaisdois(int maisdois) {
        this.maisdois = maisdois;
    }

    public void setSomamaisquatro(int maisquatro) {
        this.maisquatro = maisquatro;
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
    public void setnumcartasjogador4(int numcartasjogador4){
        this.numcartasjogador4 = numcartasjogador4;
    }
    public String getactualPlayer() {
        return actualPlayer;
    }
    public void setactualPlayer(String actualPlayer) {
        this.actualPlayer = actualPlayer;
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
    public List<String> getnumber() {
        return number;
    }
    public void setnumber(List<String> number) {
        this.number = number;
    }

////////////////////////////////////////////////////////////////////////////////////////
    public String somamais2() {
        if (actualPlayer.equals(jogador1)) {
            numcartasjogador2 += 2;
            System.out.println("O jogador 2 vai ter que comprar 2 cartas");
            return jogador2;
        } else if (actualPlayer.equals(jogador2)) {
            numcartasjogador3 += 2;
            System.out.println("O jogador 3 vai ter que comprar 2 cartas");
            return jogador3;
        } else if (actualPlayer.equals(jogador3)) {
            numcartasjogador4 += 2;
            System.out.println("O jogador 4 vai ter que comprar 2 cartas");
            return jogador4;
        } else if (actualPlayer.equals(jogador4)) {
            numcartasjogador1 += 2;
            System.out.println("O jogador 1 vai ter que comprar 2 cartas");
            return jogador1;
        } else {
            System.out.println("O próximo jogador vai ter que comprar 2 cartas");
            return "";
        }
    }
public String somamais4() {
    if (actualPlayer.equals(jogador1)) {
        numcartasjogador2 += 4;
        System.out.println("O jogador 2 vai ter que comprar 4 cartas");
        return jogador2;
    } else if (actualPlayer.equals(jogador2)) {
        numcartasjogador3 += 4;
        System.out.println("O jogador 3 vai ter que comprar 4 cartas");
        return jogador3;
    } else if (actualPlayer.equals(jogador3)) {
        numcartasjogador4 += 4;
        System.out.println("O jogador 4 vai ter que comprar 4 cartas");
        return jogador4;
    } else if (actualPlayer.equals(jogador4)) {
        numcartasjogador1 += 4;
        System.out.println("O jogador 1 vai ter que comprar 4 cartas");
        return jogador1;
    } else {
        System.out.println("O próximo jogador vai ter que comprar 4 cartas");
        return "";
    }
}

}