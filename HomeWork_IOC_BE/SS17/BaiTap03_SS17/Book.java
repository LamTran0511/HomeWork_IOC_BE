package IOC_BE.SS17.BaiTap03_SS17;


import java.util.Scanner;

public class Book {
    private int id;
    private String title;
    private String author;
    private int publishYear;
    private double price;

    public Book(String title, String author, int publishYear, double price) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.price = price;
    }

    public Book(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void inputData(Scanner scanner) {
        while (true) {
            System.out.print("Nhập tên sách: ");
            String inputTitle = scanner.nextLine();
            if (inputTitle.trim().isEmpty()) {
                System.out.println("Tên sách không được để trống. Vui lòng thử lại.");
            } else {
                this.title = inputTitle;
                break;
            }
        }

        while (true) {
            System.out.print("Nhập tên tác giả: ");
            String inputAuthor = scanner.nextLine();
            if (inputAuthor.trim().isEmpty()) {
                System.out.println("Tên tác giả không được để trống. Vui lòng thử lại.");
            } else {
                this.author = inputAuthor;
                break;
            }
        }

        while (true) {
            System.out.print("Nhập giá sách: ");
            String inputPrice = scanner.nextLine();
            try {
                double priceValue = Double.parseDouble(inputPrice);
                if (priceValue < 0) {
                    System.out.println("Giá sách không được âm. Vui lòng thử lại.");
                } else {
                    this.price = priceValue;
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Giá sách phải là một số hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("|%-5d|%-50s|%-30s|%-20.2f|", id, title, author, price));
        return builder.toString();
    }
}