package order;

public class PriorityOrder extends Order {
    public PriorityOrder(String id, double amount) {
        super(id, amount);
    }

    public double calculateTotal() {
        return amount + 50; // priority fee
    }
}