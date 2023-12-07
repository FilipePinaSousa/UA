package uno;

import java.util.ArrayList;
import java.util.Arrays;

public class cartasnumeros extends cores {
    private ArrayList<Integer> number = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
    private int actualnumber;
    private int nextnumber;
    
    public ArrayList<Integer> getnumbers(){
        return number;
    }
    public void setnumbers(int index){
        this.number = new ArrayList<>(Arrays.asList(number.get(index)));
    }


    public cartasnumeros(String color, ArrayList<Integer> number) {
        super(color);
        this.number = number;
    }   
    public int getactualnumber(){
        return actualnumber;
    }
    public void setactualnumber(int actualnumber){
        this.actualnumber = actualnumber;
    }
    public int getnextnumber(){
        return nextnumber;
    }
    public void setnextnumber(int nextnumber){
        this.nextnumber = nextnumber;
    }


    public boolean samenumbers(ArrayList<Integer> number){
       if( actualnumber == nextnumber){
           return true;
       }
       else{
           return false;
       }
        
    }


    @Override
    public int hashCode(){
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + number.hashCode();
        return result;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(!super.equals(obj))
            return false;
        if(getClass() != obj.getClass())
            return false;
        cartasnumeros other = (cartasnumeros) obj;
        if(number != other.number)
            return false;
        return true;
    }
}
