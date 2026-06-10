
import order.*;
import payment.*;
import notification.*;
import storage.*;
import service.*;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create order
        Order order = new DiscountedOrder("ORD101", 1000);

        // Choose payment method
        System.out.println("Choose Payment Method:");
        System.out.println("1. UPI");
        System.out.println("2. Credit Card");
        System.out.println("3. Wallet");

        int choice = sc.nextInt();

        PaymentMethod payment;

        switch (choice) {
            case 1:
                payment = new UPIPayment();
                break;
            case 2:
                payment = new CreditCardPayment();
                break;
            case 3:
                payment = new WalletPayment();
                break;
            default:
                System.out.println("Invalid choice, defaulting to UPI");
                payment = new UPIPayment();
        }

        // Choose notification (fixed for now)
        NotificationService notification = new EmailNotification();

        // Choose storage (fixed for now)
        OrderRepository repo = new FileRepository();

        // Process order
        OrderService service = new OrderService(payment, notification, repo);
        service.processOrder(order);

        sc.close();
    }
}