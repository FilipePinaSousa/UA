package aula11;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class EnergyUsageReport {
    private HashMap<Integer, Customer> customers;

    public EnergyUsageReport() {
        customers = new HashMap<Integer, Customer>();
    }

    public void load(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split("\\|");

                int customerId = Integer.parseInt(fields[0]);
                List<Double> meterReadings = new ArrayList<Double>();
                for (int i = 1; i < fields.length; i++) {
                    double reading = Double.parseDouble(fields[i]);
                    meterReadings.add(reading);
                }

                Customer customer = new Customer(customerId, meterReadings);
                customers.put(customerId, customer);
            }

            scanner.close();
        } catch (IOException e) {
            System.err.println("Error loading file: " + e.getMessage());
        }
    }

    public void addCustomer(Customer customer) {
        int customerId = customer.getCustomerId();
        customers.put(customerId, customer);
    }

    public void removeCustomer(int customerId) {
        customers.remove(customerId);
    }

    public Customer getCustomer(int customerId) {
        return customers.get(customerId);
    }

    public double calculateTotalUsage(int customerId) {
        Customer customer = customers.get(customerId);
        if (customer == null) {
            return 0.0;
        }

        List<Double> readings = customer.getMeterReadings();
        double totalUsage = 0.0;
        for (double reading : readings) {
            totalUsage += reading;
        }

        return totalUsage;
    }

    public void generateReport(String filename) {
        try {
            File file = new File(filename);
            java.io.PrintWriter output = new java.io.PrintWriter(file);

            for (int customerId : customers.keySet()) {
                double totalUsage = calculateTotalUsage(customerId);
                output.println(customerId + " " + totalUsage);
            }

            output.close();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
