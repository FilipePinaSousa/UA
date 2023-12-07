package aula04;

import java.util.ArrayList;

public class exe02 {
    static class Product {
        private String name;
        private double price;
        private int quantity;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public double getTotalValue() {
            return price * quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        @Override
        public String toString() {
            return String.format("%-11s%6.2f%4d%14.2f", name, price, quantity, getTotalValue());
        }
    }

    static class CashRegister {
        private ArrayList<Product> products = new ArrayList<>();

        public void addProduct(Product product) {
            products.add(product);
        }

        public double getTotalValue() {
            double total = 0;
            for (Product p : products) {
                total += p.getTotalValue();
            }
            return total;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%-11s%6s%9s%9s\n", "Product", "Price", "Quantity", "Total"));
            for (Product p : products) {
                sb.append(p.toString() + "\n");
            }
            sb.append(String.format("Total value:%27.2f", getTotalValue()));
            return sb.toString();
        }
    }

    public static void main(String[] args) {

        // Cria e adiciona 5 produtos
        CashRegister cr = new CashRegister();
        cr.addProduct(new Product("Book", 9.99, 3));
        cr.addProduct(new Product("Pen", 1.99, 10));
        cr.addProduct(new Product("Headphones", 29.99, 2));
        cr.addProduct(new Product("Notebook", 19.99, 5));
        cr.addProduct(new Product("Phone case", 5.99, 1));
        
        System.out.println(cr);

    }
}
