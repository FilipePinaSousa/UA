package aula04;

import java.util.Scanner;

class Car {
    public String make;
    public String model;
    public int year;
    public int mileage;

    public Car(String make, String model, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    public void drive(int distance) {
        this.mileage += distance;
    }

}

public class CarDemo {

    static Scanner sc = new Scanner(System.in);

    static int registerCars(Car[] cars) {
        // TODO: pede dados dos carros ao utilizador e acrescenta ao vetor
        // registo de carros termina quando o utilizador inserir uma linha vazia 
        // devolve número de carros registados
        System.out.print("Insira dados do carro (marca modelo ano quilómetros): ");
        return 0;
   }

    static void registerTrips(Car[] cars, int numCars) {
        // TODO: pede dados das viagens ao utilizador e atualiza informação do carro
        // registo de viagens termina quando o utilizador inserir uma linha vazia 
        System.out.print("Registe uma viagem no formato \"carro:distância\": ");
    }


    static void listCars(Car[] cars) {
        System.out.println("\nCarros registados: ");
        
        // Exemplo de resultado
        // Carros registados: 
        // Toyota Camry, 2010, mileage: 234346
        // Renault Megane Sport Tourer, 2015, mileage: 32536
        
        System.out.println("\n");
    }

    public static void main(String[] args) {

        Car[] cars = new Car[10];

        int numCars = registerCars(cars);

        if (numCars>0) {
            listCars(cars);
            registerTrips(cars, numCars);
            listCars(cars);
        }

        sc.close();

    }
}