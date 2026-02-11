package IOC_BE.SS15.BaiTap01_SS15;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final MovieManager<Movie> manager = new MovieManager<>();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = readInt("Chon: ");

            switch (choice) {
                case 1 -> addMovie();
                case 2 -> updateMovie();
                case 3 -> deleteMovie();
                case 4 -> showMovies();
                case 5 -> searchMovie();
                case 6 -> filterMovies();
                case 0 -> {
                    System.out.println("Thoat chuong trinh!");
                    return;
                }
                default -> System.out.println("Lua chon khong hop le!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n===== QUAN LY PHIM =====");
        System.out.println("1. Them phim moi");
        System.out.println("2. Sua phim theo id");
        System.out.println("3. Xoa phim theo id");
        System.out.println("4. Hien thi danh sach phim");
        System.out.println("5. Tim kiem phim theo ten");
        System.out.println("6. Loc phim rating > 8.0");
        System.out.println("0. Thoat");
    }

    private static void addMovie() {
        System.out.println("\n--- Them phim moi ---");
        int id = readInt("Nhap id: ");
        System.out.print("Nhap ten phim: ");
        String title = sc.nextLine();
        System.out.print("Nhap dao dien: ");
        String director = sc.nextLine();

        LocalDate releaseDate = readDate("Nhap ngay phat hanh (yyyy-MM-dd): ");
        double rating = readDouble("Nhap rating (0-10): ", 0, 10);

        Movie m = new Movie(id, title, director, releaseDate, rating);
        manager.add(m);
        System.out.println("✅ Da them phim: " + m);
    }

    private static void updateMovie() {
        System.out.println("\n--- Sua phim ---");
        int id = readInt("Nhap id phim can sua: ");
        Movie m = manager.findById(id);

        if (m == null) {
            System.out.println("❌ Khong tim thay phim co id = " + id);
            return;
        }

        System.out.println("Phim hien tai: " + m);
        System.out.print("Nhap ten moi (bo trong neu khong doi): ");
        String newTitle = sc.nextLine();
        if (!newTitle.trim().isEmpty()) m.setTitle(newTitle);

        System.out.print("Nhap dao dien moi (bo trong neu khong doi): ");
        String newDirector = sc.nextLine();
        if (!newDirector.trim().isEmpty()) m.setDirector(newDirector);

        System.out.print("Nhap ngay moi yyyy-MM-dd (bo trong neu khong doi): ");
        String dateStr = sc.nextLine();
        if (!dateStr.trim().isEmpty()) {
            try {
                m.setReleaseDate(LocalDate.parse(dateStr));
            } catch (DateTimeParseException e) {
                System.out.println("❌ Sai dinh dang ngay. Giu nguyen ngay cu.");
            }
        }

        System.out.print("Nhap rating moi 0-10 (bo trong neu khong doi): ");
        String ratingStr = sc.nextLine();
        if (!ratingStr.trim().isEmpty()) {
            try {
                double newRating = Double.parseDouble(ratingStr);
                if (newRating < 0 || newRating > 10) {
                    System.out.println("❌ Rating phai trong 0-10. Giu nguyen rating cu.");
                } else {
                    m.setRating(newRating);
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Rating phai la so. Giu nguyen rating cu.");
            }
        }

        System.out.println("✅ Da cap nhat: " + m);
    }

    private static void deleteMovie() {
        System.out.println("\n--- Xoa phim ---");
        int id = readInt("Nhap id phim can xoa: ");
        boolean ok = manager.deleteById(id);
        System.out.println(ok ? "✅ Da xoa phim!" : "❌ Khong tim thay phim de xoa!");
    }

    private static void showMovies() {
        System.out.println("\n--- Danh sach phim ---");
        List<Movie> list = manager.getAll();
        if (list.isEmpty()) {
            System.out.println("(Danh sach rong)");
            return;
        }
        for (Movie m : list) {
            System.out.println(m);
        }
    }

    private static void searchMovie() {
        System.out.println("\n--- Tim kiem phim theo ten ---");
        System.out.print("Nhap ten phim can tim: ");
        String keyword = sc.nextLine();

        List<Movie> result = manager.searchByTitle(keyword);
        if (result.isEmpty()) {
            System.out.println("Không tìm thấy phim");
            return;
        }
        for (Movie m : result) System.out.println(m);
    }

    private static void filterMovies() {
        System.out.println("\n--- Loc phim rating > 8.0 ---");
        List<Movie> result = manager.filterRatingGreaterThan(8.0);
        if (result.isEmpty()) {
            System.out.println("(Khong co phim nao rating > 8.0)");
            return;
        }
        for (Movie m : result) System.out.println(m);
    }

    // ======= Ham nhap an toan (try/catch) =======

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui long nhap so nguyen!");
            }
        }
    }

    private static double readDouble(String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine();
            try {
                double v = Double.parseDouble(s);
                if (v < min || v > max) {
                    System.out.println("❌ Gia tri phai nam trong [" + min + ", " + max + "]");
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui long nhap so (vd: 8.5)!");
            }
        }
    }

    private static LocalDate readDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine();
            try {
                return LocalDate.parse(s); // yyyy-MM-dd
            } catch (DateTimeParseException e) {
                System.out.println("❌ Sai dinh dang! Hay nhap yyyy-MM-dd (vd: 2026-02-11)");
            }
        }
    }
}
