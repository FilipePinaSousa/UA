
package entregadepedidos;
import java.time.LocalDateTime;
import java.util.List;
class Order {

    private static int nextId = 1;

    private int id;
    private List<Item> items;
    private String storeId;
    private LocalDateTime dateTime;
    private boolean express;

    public Order(List<Item> items, String storeId, LocalDateTime dateTime, boolean express) {
        this.id = nextId++;
        this.items = items;
        this.storeId = storeId;
        this.dateTime = dateTime;
        this.express = express;
    }

    public int getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getStoreId() {
        return storeId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public boolean isExpress() {
        if (express) {
            return true;
        } else {
            return false;
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        if (express) {
            totalPrice *= 1.3; // 30% de acrescimo
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item.getName()).append(":").append(item.getPrice()).append("|");
        }
        String itemsString = sb.toString();
        if (itemsString.endsWith("|")) {
            itemsString = itemsString.substring(0, itemsString.length() - 1);
        }
        return "Order{" +
                "id=" + id +
                ", items=" + itemsString +
                ", storeId='" + storeId + '\'' +
                ", dateTime=" + dateTime +
                ", express=" + express +
                '}';
    }
}
