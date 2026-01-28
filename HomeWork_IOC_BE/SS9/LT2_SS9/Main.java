package SS9.LT2_SS9;

public class Main {
    public static void main(String[] args) {
        run();
    }
    public static void run() {
        Book[]  books = new Book[3];

        books[0] = new Book("Java", "James", 100.0);
        books[1] = new Book("Python", "Guido", 120.0);
        books[2] = new Book("C++", "Bjarne", 150.0);

        System.out.println("----------------- List of book -----------------");
        for (Book book : books) {
            System.out.println(book + "\n");
        }
    }
}