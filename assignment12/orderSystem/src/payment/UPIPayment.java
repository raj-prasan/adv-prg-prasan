package payment;

public class UPIPayment implements PaymentMethod {
    public boolean pay(double amount) {
        System.out.println("Paid using UPI: " + amount);
        return true;
    }
}