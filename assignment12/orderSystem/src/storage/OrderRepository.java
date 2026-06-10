package storage;
import order.Order;
public interface OrderRepository {
    void save(Order order);
}
