package storage;
import order.Order;
public class DatabaseRepository implements OrderRepository {
    public void save(Order order) {
        System.out.println("Order saved to Database: " + order.getId());
    }
}