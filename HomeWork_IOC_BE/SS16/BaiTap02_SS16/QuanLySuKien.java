package IOC_BE.SS16.BaiTap02_SS16;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Event {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Event(String name, LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() { return name; }
    public LocalDateTime getStartDate() { return startDate; }
    public LocalDateTime getEndDate() { return endDate; }

    public String getStatus(LocalDateTime now) {
        if (now.isBefore(startDate)) return "SẮP TỚI";
        if (now.isAfter(endDate)) return "ĐÃ QUA";
        return "ĐANG DIỄN RA";
    }

    @Override
    public String toString() {
        return "Event{name='" + name + '\'' +
                ", start=" + startDate +
                ", end=" + endDate + '}';
    }

    public String toPrettyString(DateTimeFormatter fmt, LocalDateTime now) {
        return String.format(
                "Event{name='%s', start='%s', end='%s', status='%s'}",
                name,
                startDate.format(fmt),
                endDate.format(fmt),
                getStatus(now)
        );
    }
}

public class QuanLySuKien {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Event> events = new ArrayList<>();
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = readInt("Chọn chức năng: ");

            switch (choice) {
                case 1 -> addEvent();
                case 2 -> showEvents();
                case 3 -> checkEventStatusByName();
                case 0 -> {
                    System.out.println("Thoát chương trình.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("===== QUẢN LÝ SỰ KIỆN (DateTime API) =====");
        System.out.println("1. Thêm sự kiện");
        System.out.println("2. In danh sách sự kiện");
        System.out.println("3. Kiểm tra trạng thái sự kiện (theo tên)");
        System.out.println("0. Thoát");
        System.out.println("Định dạng thời gian: dd/MM/yyyy HH:mm (vd: 26/03/2026 08:30)");
    }

    // ===== Chức năng 2: Thêm sự kiện =====
    private static void addEvent() {
        String name = readNonEmptyString("Nhập tên sự kiện: ");

        LocalDateTime start = readDateTimeWithRetry("Nhập thời gian bắt đầu (dd/MM/yyyy HH:mm): ");
        LocalDateTime end = readDateTimeWithRetry("Nhập thời gian kết thúc (dd/MM/yyyy HH:mm): ");

        if (!end.isAfter(start)) {
            System.out.println("❌ Thời gian kết thúc phải sau thời gian bắt đầu!");
            return;
        }

        events.add(new Event(name, start, end));
        System.out.println("✅ Thêm sự kiện thành công!");
    }

    // ===== Chức năng 4: In danh sách =====
    private static void showEvents() {
        if (events.isEmpty()) {
            System.out.println("Danh sách sự kiện trống.");
            return;
        }

        LocalDateTime now = LocalDateTime.now();
        System.out.println("---- Danh sách sự kiện ----");
        for (int i = 0; i < events.size(); i++) {
            Event e = events.get(i);
            System.out.printf("%d) %s%n", i + 1, e.toPrettyString(FMT, now));
        }
    }

    // ===== Chức năng 3: Kiểm tra trạng thái (theo tên) =====
    private static void checkEventStatusByName() {
        if (events.isEmpty()) {
            System.out.println("Chưa có sự kiện nào để kiểm tra.");
            return;
        }

        String keyword = readNonEmptyString("Nhập tên (hoặc từ khóa) sự kiện cần kiểm tra: ").toLowerCase();
        LocalDateTime now = LocalDateTime.now();

        boolean found = false;
        for (Event e : events) {
            if (e.getName().toLowerCase().contains(keyword)) {
                found = true;
                System.out.println(e.toPrettyString(FMT, now));
            }
        }

        if (!found) {
            System.out.println("❌ Không tìm thấy sự kiện phù hợp.");
        }
    }

    // ===== Helpers nhập liệu + xử lý ngoại lệ =====
    private static LocalDateTime readDateTimeWithRetry(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                return LocalDateTime.parse(input, FMT);
            } catch (DateTimeParseException ex) {
                System.out.println("⚠️ Sai định dạng! Hãy nhập theo dd/MM/yyyy HH:mm (vd: 26/03/2026 08:30)");
            }
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("⚠️ Không được để trống.");
        }
    }
}