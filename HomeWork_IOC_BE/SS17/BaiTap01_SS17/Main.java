package IOC_BE.SS17.BaiTap01_SS17;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieManagement movieManagement = new MovieManagement();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Thêm phim mới");
            System.out.println("2. Hiển thị danh sách phim");
            System.out.println("3. Cập nhật thông tin phim");
            System.out.println("4. Xóa phim");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    movieManagement.addMovie(scanner);
                    break;
                case "2":
                    movieManagement.displayMovies();
                    break;
                case "3":
                    movieManagement.updateMovie(scanner);
                    break;
                case "4":
                    movieManagement.deleteMovie(scanner);
                    break;
                case "5":
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        }
    }
}
