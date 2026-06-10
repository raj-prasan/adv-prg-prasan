package order;

public class DiscountedOrder extends Order {
    public DiscountedOrder(String id, double amount) {
        super(id, amount);
    }

    public double calculateTotal() {
        return amount * 0.9; // 10% discount
    }
}