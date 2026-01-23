public class BaiTap02_SS8 {
    static class book {
        String title;
        String author;
        double price;

        public book(String title, String author, double price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }
    }
    public static void main(String[] args) {
        book b1 = new book("Java","Nguyen Van A",15.000);
        System.out.println("Title: "+ b1.title+", Author: "+ b1.author+", Price: "+ b1.price);
    }
}
