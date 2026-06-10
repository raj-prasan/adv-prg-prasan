import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<LibraryItem> items = new ArrayList<>();

        items.add(new Book("Java Basics", 2020, "James Gosling"));
        items.add(new DVD("Inception", 2010, 148, "Sci-Fi"));
        items.add(new Book("DSA Guide", 2005, "John Doe")); // uses overloaded constructor

        for (LibraryItem item : items) {
            item.displayInfo(); // calls correct overridden method
        }


        System.out.println("Total items: " + LibraryItem.getTotalItems());
    }
}