package aula04;

import java.util.Random;

class Car {
    private String make;
    private String model;
    private int year;
    private int mileage;

    public Car(String make, String model, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    public void drive(int distance) {
        this.mileage += distance;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }
}

public class exe03 {

    static void listCars(Car[] cars) {
        System.out.println("Carros registrados:");
        for (Car car : cars) {
            System.out.printf("%s %s, %d, km rodados: %d\n", car.getMake(), car.getModel(), car.getYear(), car.getMileage());
        }
    }

    public static void main(String[] args) {

        Car[] cars = new Car[3];
        cars[0] = new Car("Renault", "Megane Sport Tourer", 2015, 35356);
        cars[1] = new Car("Toyota", "Camry", 2010, 32456);
        cars[2] = new Car("Mercedes", "Vito", 2008, 273891);

        listCars(cars);

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int j = rand.nextInt(3); 
            int mileage = rand.nextInt(1000); 
            System.out.printf("Carro %d viajou %d quilômetros.\n", j, mileage);
            cars[j].drive(mileage);
        }

        listCars(cars);

    }
}
