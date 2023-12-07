package aula09;

public abstract class Plane {
    private String id;
    private int passengers;
    private int maxPassengers;
    private int maxSpeed;
    private String manufacturer;
    private String model;
    private int year;


    
    public Plane(String id, String manufacturer, String model, int year, int maxPassengers, int maxSpeed) {
        this.id = id;
        this.maxPassengers = maxPassengers;
        this.passengers = 0;
        this.maxSpeed = maxSpeed;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;

    }
	public String getId() {
        return id;
    }
    public int getCapacity() {
        return maxPassengers;
    }
    public int getPassengers() {
        return passengers;
    }
    public void addPassengers(int passengers) {
        this.passengers += passengers;
    }
    public void removePassengers(int passengers) {
        this.passengers -= passengers;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    public double getMaxSpeed() {
        return maxSpeed;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
    public  abstract String getPlaneType();

    public String toString() {
        return "id: " + id + " Capacity: " + maxPassengers + " Passengers: " + passengers;
    }


}
