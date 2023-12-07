
package entregadepedidos;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManager {




    private static Map<Integer, Order> orders;

    public OrderManager() {
        orders = new HashMap<>();
    }

    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }

    public void removeOrder(Order order) {
        orders.remove(order.getId());
    }

    public Order searchOrder(int id) {
        return orders.getOrDefault(id, null);
    }

    public double calculateOrderCost(int id, OrderCostCalculator calculator) {
        Order order = searchOrder(id);
        if (order != null) {
            return calculator.calculate(order);
        }
        return -1;
    }

    public static void printAllOrders() {
        for (Order order : orders.values()) {
            System.out.println(order);
        }
    }

    public void saveOrdersToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            for (Order order : orders.values()) {
                int customerID = order.getId();
                int storeID = order.getId();
                String items = formatItems(order.getItems());
                String dateTime = order.getDateTime().format(formatter);
                String type = order.isExpress() ? "Expresso" : "Normal";
                String line = customerID + ";" + storeID + ";" + items + ";" + dateTime + ";" + type + "\n";
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String formatItems(List<Item> items) {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item.getName()).append(":").append(item.getPrice()).append("|");
        }
        sb.deleteCharAt(sb.length() - 1); // remove o último "|"
        return sb.toString();
    }

    public Order[] getOrders() {
        return null;
    }
    
}

