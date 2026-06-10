package service;
import order.Order;
import payment.*;
import notification.*;
import storage.*;


public class OrderService {

    private PaymentMethod paymentMethod;
    private NotificationService notificationService;
    private OrderRepository repository;

    // Dependency Injection (DIP)
    public OrderService(PaymentMethod paymentMethod,
                        NotificationService notificationService,
                        OrderRepository repository) {
        this.paymentMethod = paymentMethod;
        this.notificationService = notificationService;
        this.repository = repository;
    }

    public void processOrder(Order order) {
        double total = order.calculateTotal();

        if (paymentMethod.pay(total)) {
            repository.save(order);
            notificationService.send("Order " + order.getId() + " processed successfully!");
        } else {
            System.out.println("Payment failed!");
        }
    }
}