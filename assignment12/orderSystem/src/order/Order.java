package order;

public abstract class Order {
    protected String id;
    protected double amount;

    public Order(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() { return id; }
    public double getAmount() { return amount; }

    public abstract double calculateTotal();
}
