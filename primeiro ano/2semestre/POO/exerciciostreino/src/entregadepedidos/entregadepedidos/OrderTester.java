
package entregadepedidos;

    
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class OrderTester {
    public static void main(String[] args) throws IOException{
        
        OrderManager orderManager = new OrderManager();

        // Adiciona pedidos ao sistema
        List<Item> items1 = new ArrayList<>();
        items1.add(new Item("Item 1", 10.0));
        items1.add(new Item("Item 2", 20.0));
        Order order1 = new Order(items1, "Loja 1", LocalDateTime.now(), false);
        orderManager.addOrder(order1);

        List<Item> items2 = new ArrayList<>();
        items2.add(new Item("Item 3", 15.0));
        items2.add(new Item("Item 4", 25.0));
        Order order2 = new Order(items2, "Loja 2", LocalDateTime.now(), true);
        orderManager.addOrder(order2);

        // Remove pedidos do sistema
        orderManager.removeOrder(order1);

        // Lê dados de pedidos de um arquivo
        readOrdersFromFile(orderManager, "pedidos.txt");

        // Procura um pedido específico
        Order foundOrder = orderManager.searchOrder(2);
        if (foundOrder != null) {
            System.out.println("Pedido encontrado: " + foundOrder);
        } else {
            System.out.println("Pedido não encontrado");
        }

        // Imprime informações de todos os pedidos
        OrderManager.printAllOrders();

        // Calcula o custo de um pedido específico
        double orderCost = orderManager.calculateOrderCost(1, new StandardOrderCostCalculator());
        if (orderCost != -1) {
            System.out.println("Custo do pedido 1: " + orderCost);
        } else {
            System.out.println("Pedido 1 não encontrado");
        }

        // Calcula o custo de todos os pedidos de um mês
        double totalCost = 0.0;
        for (Order order : orderManager.getOrders()) {
            if (order.getDateTime().getMonth().equals(Month.MAY)) {
                totalCost += orderManager.calculateOrderCost(order.getId(), new StandardOrderCostCalculator());
            }
        }
        System.out.println("Custo total dos pedidos em maio: " + totalCost);

        // Salva os pedidos em um arquivo
        orderManager.saveOrdersToFile("pedidos_output.txt");
    }

    private static void readOrdersFromFile(OrderManager orderManager, String filename) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                String storeId = data[0];
                List<Item> items = parseItems(data[1]);
                LocalDateTime dateTime;
                try {
                    dateTime = LocalDateTime.parse(data[2], formatter);
                } catch (DateTimeParseException e) {
                    // Handle the case where the date and time string is invalid
                    continue;
                }
                boolean express = data[3].equalsIgnoreCase("Expresso");
                Order order = new Order(items, storeId, dateTime, express);
                orderManager.addOrder(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    private static List<Item> parseItems(String itemsString) {
        List<Item> items = new ArrayList<>();
        String[] itemsData = itemsString.split(",");
        for (String itemData : itemsData) {
            String[] itemDataParts = itemData.split(":");
            if (itemDataParts.length < 2) {
                // Handle the case where the item data is invalid
                continue;
            }
            String name = itemDataParts[0];
            double price = Double.parseDouble(itemDataParts[1]);
            items.add(new Item(name, price));
        }
        return items;
    }
    
    
    



    }
