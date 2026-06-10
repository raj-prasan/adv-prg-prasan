package payment;

public class CreditCardPayment implements PaymentMethod{
    public boolean pay(double amount){
        System.out.println("Paid using Credit Card: " + amount);
        return true;
    }
}
