package aula09;

public class MilitaryPlane extends Plane {
    private int numMissiles;

    public MilitaryPlane(String id, String manufacturer, String model, int year, int maxPassengers, int maxSpeed, int numMissiles) {
        super(id, manufacturer, model, year, maxPassengers, maxSpeed);
        this.numMissiles = numMissiles;
    }

    public void setNumMissiles(int numMissiles) {
        this.numMissiles = numMissiles;
    }

    public int getNumMissiles() {
        return numMissiles;
    }
    @Override
    public String getPlaneType() {
        return "Militar";
    }
    @Override
    public String toString() {
        return super.toString() + ", Num Missiles: " + numMissiles + ", Plane Type: " + getPlaneType() + "";
    }

   

}
