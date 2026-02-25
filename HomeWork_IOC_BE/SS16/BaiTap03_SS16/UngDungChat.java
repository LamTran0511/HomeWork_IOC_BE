package IOC_BE.SS16.BaiTap03_SS16;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Message {
    private final String sender;
    private final String content;
    private final LocalDateTime timestamp;

    public Message(String sender, String content, LocalDateTime timestamp) {
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getSender() { return sender; }
    public String getContent() { return content; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return String.format("[%s] %s: %s",
                timestamp.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                sender,
                content
        );
    }
}

public class UngDungChat {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Message> messages = new ArrayList<>();

    private static final DateTimeFormatter TS_FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final DateTimeFormatter DAY_FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = readInt("Chọn chức năng: ");

            switch (choice) {
                case 1 -> sendMessage();
                case 2 -> showHistory();
                case 3 -> filterBySender();
                case 4 -> filterByDate();
                case 0 -> {
                    System.out.println("Thoát ứng dụng.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("===== SIMPLE CHAT (Console) =====");
        System.out.println("1. Gửi tin nhắn");
        System.out.println("2. Xem lịch sử chat");
        System.out.println("3. Lọc tin nhắn theo người gửi");
        System.out.println("4. Lọc tin nhắn theo ngày (dd/MM/yyyy)");
        System.out.println("0. Thoát");
    }

    // 3. Gửi tin nhắn (auto timestamp)
    private static void sendMessage() {
        String sender = readNonEmptyString("Nhập tên người gửi: ");
        String content = readNonEmptyString("Nhập nội dung: ");
        Message msg = new Message(sender, content, LocalDateTime.now());
        messages.add(msg);
        System.out.println("✅ Đã gửi: " + msg.toString());
    }

    // 4. Xem lịch sử chat
    private static void showHistory() {
        if (messages.isEmpty()) {
            System.out.println("Lịch sử chat trống.");
            return;
        }
        System.out.println("---- LỊCH SỬ CHAT ----");
        // Sắp xếp theo thời gian (phòng trường hợp sau này nạp dữ liệu)
        messages.stream()
                .sorted(Comparator.comparing(Message::getTimestamp))
                .forEach(System.out::println);
    }

    // 5. Lọc theo người gửi (Streams)
    private static void filterBySender() {
        if (messages.isEmpty()) {
            System.out.println("Chưa có tin nhắn để lọc.");
            return;
        }

        String sender = readNonEmptyString("Nhập tên người gửi cần lọc: ").toLowerCase();

        List<Message> filtered = messages.stream()
                .filter(m -> m.getSender().toLowerCase().equals(sender))
                .sorted(Comparator.comparing(Message::getTimestamp))
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("❌ Không có tin nhắn nào từ: " + sender);
            return;
        }

        System.out.println("---- TIN NHẮN TỪ '" + sender + "' ----");
        filtered.forEach(System.out::println);
        System.out.println("Tổng: " + filtered.size() + " tin nhắn.");
    }

    // 6. Lọc theo ngày (dd/MM/yyyy) + 7. try/catch bắt sai format
    private static void filterByDate() {
        if (messages.isEmpty()) {
            System.out.println("Chưa có tin nhắn để lọc.");
            return;
        }

        LocalDate day = readDateWithRetry("Nhập ngày cần lọc (dd/MM/yyyy): ");

        List<Message> filtered = messages.stream()
                .filter(m -> m.getTimestamp().toLocalDate().equals(day))
                .sorted(Comparator.comparing(Message::getTimestamp))
                .collect(Collectors.toList());

        System.out.println("---- TIN NHẮN NGÀY " + day.format(DAY_FMT) + " ----");
        if (filtered.isEmpty()) {
            System.out.println("Không có tin nhắn trong ngày này.");
        } else {
            filtered.forEach(System.out::println);
            System.out.println("Tổng: " + filtered.size() + " tin nhắn.");
        }
    }

    // ===== Helpers nhập liệu =====
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

    private static LocalDate readDateWithRetry(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                return LocalDate.parse(input, DAY_FMT);
            } catch (DateTimeParseException e) {
                System.out.println("⚠️ Sai định dạng ngày! Nhập theo dd/MM/yyyy (vd: 25/02/2026)");
            }
        }
    }
}