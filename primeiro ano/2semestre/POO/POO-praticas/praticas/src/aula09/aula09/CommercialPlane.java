package aula09;


public class CommercialPlane extends Plane {
    private int numOfCrewMembers;

    public CommercialPlane(String id, String manufacturer, String model, int year, int maxSpeed, int numOfCrewMembers, int maxPassengers) {
        super(id, manufacturer, model, year, maxPassengers, maxSpeed);
        this.numOfCrewMembers = numOfCrewMembers;
        

    }


    public void setNumOfCrewMembers(int numOfCrewMembers) {
        this.numOfCrewMembers = numOfCrewMembers;

    }
    public int getNumOfCrewMembers() {
        return numOfCrewMembers;
    }

    @Override
    public String getPlaneType() {
        return "Comercial";
    }
    public String toString() {
        return super.toString() + ", numOfCrewMembers: " + numOfCrewMembers + ", Plane Type: " + getPlaneType() + "";
    }
}


