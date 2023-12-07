package entregadepedidos;

public class StandardOrderCostCalculator implements OrderCostCalculator {
    @Override
    public double calculate(Order order) {
        // Implement the calculation logic here
        // and return the calculated value as a double
        return order.getTotalPrice();
    }
}
