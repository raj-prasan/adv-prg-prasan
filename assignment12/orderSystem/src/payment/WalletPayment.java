package payment;

public class WalletPayment implements PaymentMethod {
    public boolean pay(double amount) {
        System.out.println("Paid using Wallet: " + amount);
        return true;
    }
}