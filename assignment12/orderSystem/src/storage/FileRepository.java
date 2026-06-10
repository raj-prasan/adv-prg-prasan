package storage;

import order.Order;


import order.Order;

import java.io.FileWriter;
import java.io.IOException;

public class FileRepository implements OrderRepository {

    private static final String FILE_NAME = "orders.txt";

    @Override
    public void save(Order order) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) { // true = append
            String line = format(order);
            fw.write(line + System.lineSeparator());
            System.out.println("Order saved to file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // simple CSV-like format
    private String format(Order o) {
        return o.getId() + "," + o.getAmount() + "," + o.calculateTotal()
                + "," + o.getClass().getSimpleName();
    }
}