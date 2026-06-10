abstract class LibraryItem {
    protected String title;
    protected int year;


    private static int totalItems = 0;


    public LibraryItem(String title, int year) {
        this.title = title;
        this.year = year;
        totalItems++;
    }

    public LibraryItem(String title) {
        this(title, 0);
    }

    public abstract void displayInfo();

    public static int getTotalItems() {
        return totalItems;
    }
}