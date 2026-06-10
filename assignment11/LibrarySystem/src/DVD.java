class DVD extends LibraryItem {
    private int duration;
    private String genre;

    public DVD(String title, int year, int duration, String genre) {
        super(title, year);
        this.duration = duration;
        this.genre = genre;
    }

    @Override
    public void displayInfo() {
        System.out.println("DVD: " + title +
                ", Genre: " + genre +
                ", Duration: " + duration + " mins" +
                ", Year: " + year);
    }
}