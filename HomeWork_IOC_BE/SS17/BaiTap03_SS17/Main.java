package IOC_BE.SS17.BaiTap03_SS17;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookManagement bookManagement = new BookManagement();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Thêm sách mới");
            System.out.println("2. Hiển thị tất cả sách");
            System.out.println("3. Tìm sách theo tác giả");
            System.out.println("4. Cập nhật thông tin sách");
            System.out.println("5. Xóa sách");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    Book book = new Book();
                    book.inputData(scanner);
                    bookManagement.addBook(book);
                    break;
                case "2":
                    bookManagement.listBooks();
                    break;
                case "3":
                    System.out.print("Nhập tên tác giả: ");
                    String searchAuthor = scanner.nextLine();
                    bookManagement.getBooksByAuthor(searchAuthor);
                    break;
                case "4":
                    System.out.print("Nhập ID sách cần cập nhật: ");
                    int updateId = Integer.parseInt(scanner.nextLine());
                    Book updateBook = new Book();
                    updateBook.inputData(scanner);
                    bookManagement.updateBook(updateId, updateBook);
                    break;
                case "5":
                    System.out.print("Nhập ID sách cần xóa: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    bookManagement.deleteBookById(deleteId);
                    break;
                case "6":
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
}