package testeanopassado;

import java.time.LocalDate;
import java.util.*;

public class Event implements IEvent {
    private LocalDate data;
    private ArrayList<Activity> atividades= new ArrayList<>();
    
    
    public Event(LocalDate data) {
        this.data = data;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public ArrayList<Activity> getAtividades() {
        return atividades;
    }
    public void setAtividades(ArrayList<Activity> atividades) {
        this.atividades = atividades;
    }
    @Override
    public Event addActivity(Activity activity) {
        boolean g = false;
            for(Activity i : atividades){
                if((i.getTipo().equals("Catering")) && (activity.getTipo().equals("Catering")) ){
                    g=true;
                    break;
                }
                else{
                    g=false;
                }
            }
        
            if(!g){
                atividades.add(activity);
            }
        
        Event event = new Event(getData());
        return event ;
    }
    @Override
    public LocalDate getDate() {
        
        return getData();
    }
    @Override
    public double totalCost() {
        double total =0;
        for(Activity i : atividades){
            total += i.getNumeroParticipantes()*i.getPreçoUnico();
        }
        return total;
    }
    @Override
    public String toString() {
        return "Event [atividades=" + atividades + ", data=" + data + "]";
    }
    
    
}
