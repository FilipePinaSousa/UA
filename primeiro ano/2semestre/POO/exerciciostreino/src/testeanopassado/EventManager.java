package testeanopassado;


import java.time.LocalDate;
import java.util.*;
public class EventManager {
    private String nome;
    private Map<Client,ArrayList<Event>> clientes = new HashMap<Client,ArrayList<Event>>();

    
    
    public EventManager(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Map<Client, ArrayList<Event>> getClientes() {
        return clientes;
    }
    public void setClientes(Map<Client, ArrayList<Event>> clientes) {
        this.clientes = clientes;
    }

    public Client addClient(String  nome,String localidade){
        Client cliente = new Client(nome,localidade);
        ArrayList<Event> eventos= new ArrayList<>();
        clientes.put(cliente, eventos);
        return cliente;
    }
    public Event addEvent(Client cliente, LocalDate localDate){
        Event event = new Event(localDate);
        ArrayList<Event> eventos = clientes.get(cliente);
        eventos.add(event);
        clientes.replace(cliente, clientes.get(cliente), eventos);
        return event;

    }

    public String listClients(){
        System.out.println("Clientes:");
        for (Client i: clientes.keySet()){
            System.out.println(i.toString());

        }
        return "";

    }

    public String listEvents() {
        System.out.println("");
        System.out.println("Eventos:");
        for (Client i: clientes.keySet()){
            System.out.println(i.toString());
            ArrayList<Event> eventos = new ArrayList<>();
            eventos=clientes.get(i);
            for (Event f : eventos){
                System.out.println("*** Evento em "+f.getData()+", total="+f.totalCost()+" euros");
                for (Activity h:f.getAtividades()){
                    if(h.getTipo().equals("Sport")){
                        String m = h.getModal();
                        switch(m){
                            case "KAYAK":
                            System.out.println("       Kayak sporting activity with "+ h.getNumeroParticipantes()+" participants");
                            break;
                                
                            case "BIKE":
                            System.out.println("       Bike sporting activity with "+ h.getNumeroParticipantes()+" participants");
                            break;
                        }
                    }
                    else {
                        if(h.getTipo().equals("Catering")){
                            String m = h.getModal();
                            switch(m){
                                case "FULL_MENU":
                                System.out.println("       'Full menu' for "+ h.getNumeroParticipantes()+" participants");
                                break;
                                
                                case "DRINKS_AND_SNACKS":
                                System.out.println("       'Drinks and Snaks' for "+ h.getNumeroParticipantes()+" participants");
                                break;
                                
                                case "LIGHT_BITES":
                                System.out.println("       'Light bites' for "+ h.getNumeroParticipantes()+" participants");
                                break;

                            }
                            
                        }
                        else{
                            String m = h.getModal();
                            switch(m){
                                case "ART_MUSEUM":
                                System.out.println("       Art museum tour with "+ h.getNumeroParticipantes()+" participants");
                                break;
                                
                                case "ARCHITECTURAL_TOUR":
                                System.out.println("       Architectual tour with "+ h.getNumeroParticipantes()+" participants");
                                break;
                                
                                case "RIVER_TOUR":
                                System.out.println("       River tour with "+ h.getNumeroParticipantes()+" participants");
                                break;

                                case "WINE_TASTING":
                                System.out.println("       Wine tasting with "+ h.getNumeroParticipantes()+" participants");
                                break;

                            }
                        }
                    }
                }
            }

        }
        return "";

    }
    


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clientes == null) ? 0 : clientes.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EventManager other = (EventManager) obj;
        if (clientes == null) {
            if (other.clientes != null)
                return false;
        } else if (!clientes.equals(other.clientes))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }


    
}
