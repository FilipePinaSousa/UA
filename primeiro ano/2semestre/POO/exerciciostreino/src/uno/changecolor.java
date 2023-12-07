package uno;

public class changecolor extends cores {


    public changecolor(String color, String nextcolor, String actualcolor) {
        super(color);
        this.nextcolor = nextcolor;
        this.actualcolor = actualcolor;
        
        
    }

   
    public String mudadecor() {
        System.out.println("A cor mudou para " + nextcolor);
        switch (nextcolor) {
            case "vermelho":
                if (actualcolor == "vermelho") {
                    System.out.println("Não é possivel mudar para a mesma cor");
                } else {
                    System.out.println("A cor mudou para vermelho");
                    return nextcolor = "vermelho";
                }
            case "amarelo":
                if (actualcolor == "amarelo") {
                    System.out.println("Não é possivel mudar para a mesma cor");
                } else {
                    System.out.println("A cor mudou para amarelo");
                    return nextcolor = "amarelo";
                }
            case "verde":
                if (actualcolor == "verde") {
                    System.out.println("Não é possivel mudar para a mesma cor");
                } else {
                    System.out.println("A cor mudou para verde");
                    return nextcolor = "verde";
                }
            case "azul":
                if (actualcolor == "azul") {
                    System.out.println("Não é possivel mudar para a mesma cor");
                } else {
                    System.out.println("A cor mudou para azul");
                    return nextcolor = "azul";
                }
            default:
                System.out.println("Cor invalida");
                break;
        }
        return actualcolor;
    }
}
