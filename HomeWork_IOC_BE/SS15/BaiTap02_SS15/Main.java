package IOC_BE.SS15.BaiTap02_SS15;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final SubjectManager<Subject> manager = new SubjectManager<>();
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = readInt("Chon: ");

            switch (choice) {
                case 1 -> manager.showAll();
                case 2 -> addSubject();
                case 3 -> deleteSubject();
                case 4 -> searchSubjectByName();
                case 5 -> filterByCredits();
                case 0 -> {
                    System.out.println("Thoat chuong trinh!");
                    return;
                }
                default -> System.out.println("Lua chon khong hop le!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n===== QUAN LY MON HOC =====");
        System.out.println("1. Hien thi danh sach mon hoc");
        System.out.println("2. Them mon hoc");
        System.out.println("3. Xoa mon hoc theo code");
        System.out.println("4. Tim kiem mon hoc theo ten (Stream + Optional)");
        System.out.println("5. Loc mon hoc co credits > 3");
        System.out.println("0. Thoat");
    }

    private static void addSubject() {
        System.out.println("\n--- Them mon hoc ---");
        System.out.print("Nhap code: ");
        String code = sc.nextLine().trim();

        System.out.print("Nhap name: ");
        String name = sc.nextLine().trim();

        int credits;
        while (true) {
            try {
                credits = readInt("Nhap credits (0-10): ");
                validateCredits(credits); // nem exception neu sai
                break;
            } catch (InvalidCreditsException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }

        LocalDate startDate = readDate("Nhap startDate (yyyy-MM-dd): ");

        Subject s = new Subject(code, name, credits, startDate);
        manager.add(s);
        System.out.println("✅ Da them: " + s);
    }

    private static void deleteSubject() {
        System.out.println("\n--- Xoa mon hoc ---");
        System.out.print("Nhap code can xoa: ");
        String code = sc.nextLine().trim();

        boolean ok = manager.deleteByCode(code);
        System.out.println(ok ? "✅ Da xoa mon hoc!" : "❌ Khong tim thay mon hoc de xoa!");
    }

    private static void searchSubjectByName() {
        System.out.println("\n--- Tim kiem mon hoc theo ten ---");
        System.out.print("Nhap ten mon hoc: ");
        String keyword = sc.nextLine().trim();

        Optional<Subject> found = manager.findFirstByName(keyword);
        if (found.isPresent()) {
            System.out.println("✅ Tim thay: " + found.get());
        } else {
            System.out.println("Không có môn học phù hợp");
        }
    }

    private static void filterByCredits() {
        System.out.println("\n--- Loc mon hoc credits > 3 ---");
        List<Subject> result = manager.filterCreditsGreaterThan(3);

        if (result.isEmpty()) {
            System.out.println("(Khong co mon nao credits > 3)");
            return;
        }
        result.forEach(System.out::println);
    }

    // ===== Validate Credits (Exception Handling) =====
    private static void validateCredits(int credits) throws InvalidCreditsException {
        if (credits < 0 || credits > 10) {
            throw new InvalidCreditsException("Credits khong hop le! Chi duoc phep trong khoang 0-10.");
        }
    }

    // ===== Safe Input =====
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

    private static LocalDate readDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                return LocalDate.parse(s, FMT);
            } catch (DateTimeParseException e) {
                System.out.println("❌ Sai dinh dang ngay! Hay nhap yyyy-MM-dd (vd: 2026-02-11)");
            }
        }
    }
}
