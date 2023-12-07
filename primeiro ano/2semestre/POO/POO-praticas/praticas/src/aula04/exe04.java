package aula04;

import java.util.Scanner;
import java.util.regex.Pattern;

public class exe04 {
    static Scanner sc = new Scanner(System.in);

    public static class Car {
        public String make;
        public String model;
        public int year;
        public int kms;

        public Car(String make, String model, int year, int kms) {
            this.make = make;
            this.model = model;
            this.year = year;
            this.kms = kms;
        }

        public void drive(int distance) {
            this.kms += distance;
        }

        public String toString() {
            return String.format("%s %s, %d, kms: %d", make, model, year, kms);
        }
    }

    public static void listCars(Car[] cars) {
        System.out.println("Carros registados:");
        for (Car car : cars) {
            if (car != null) {
                System.out.println(car);
            }
        }
    }

    public static Car[] registerCars() {
        Car[] cars = new Car[10];
        System.out.println("Insira dados do carro (marca modelo ano quilómetros):");

        int index = 0;
        while (index < 10) {
            String input = sc.nextLine();

            if (input.isEmpty()) {
                break;
            }

            String[] carData = input.split(" ");

            if (carData.length != 4) {
                System.out.println("Dados mal formatados. Tente novamente.");
                continue;
            }

            String make = carData[0];
            String model = carData[1];
            int year = 0;
            int kms = 0;

            try {
                year = Integer.parseInt(carData[2]);
                kms = Integer.parseInt(carData[3]);

                if (year < 0 || kms < 0 || carData[2].length() != 4 || !Pattern.matches("[a-zA-Z]+", make)) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Dados mal formatados. Tente novamente.");
                continue;
            }

            cars[index] = new Car(make, model, year, kms);
            index++;

            if (index < 10) {
                System.out.println("Insira dados do carro (marca modelo ano quilómetros):");
            }
        }

        return cars;
    }

    public static void main(String[] args) {
        Car[] cars = registerCars();

        listCars(cars);

        // Adicionar viagens
        while (true) {
            System.out.println("Registe uma viagem no formato \"carro:distância\":");
            String input = sc.nextLine();

            if (input.isEmpty()) {
                break;
            }

            String[] tripData = input.split(":");

            if (tripData.length != 2) {
                System.out.println("Dados mal formatados. Tente novamente.");
                continue;
            }

            int carIndex = 0;
            int distance = 0;

            try {
                carIndex = Integer.parseInt(tripData[0]);
                distance = Integer.parseInt(tripData[1]);

                if (carIndex < 0 || carIndex >= 10 || distance < 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Dados mal formatados. Tente novamente.");
                continue;
            }

            if (cars[carIndex] == null) {
                System.out.println("Carro não encontrado. Tente novamente.");
                continue;

                }
    
                cars[carIndex].drive(distance);
            }
    
            listCars(cars);
    
            sc.close();
    
    }

    }
