package IOC_BE.SS14;

import java.util.ArrayList;
import java.util.Scanner;

public class BaiTap04_SS14 {

    static class InvalidPhoneNumberLengthException extends Exception {
        public InvalidPhoneNumberLengthException(String message) {
            super(message);
        }

        public static void validate(String phone) throws InvalidPhoneNumberLengthException {
            if (phone == null) {
                throw new InvalidPhoneNumberLengthException("Giá trị rỗng (null).");
            }

            if (phone.contains(" ")) {
                throw new InvalidPhoneNumberLengthException("Chứa khoảng trắng.");
            }

            if (phone.length() != 10) {
                throw new InvalidPhoneNumberLengthException("Sai độ dài (phải đúng 10 chữ số).");
            }

            for (int i = 0; i < phone.length(); i++) {
                char c = phone.charAt(i);
                if (c < '0' || c > '9') {
                    throw new InvalidPhoneNumberLengthException("Chứa ký tự không hợp lệ (chỉ cho phép 0-9).");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> validPhones = new ArrayList<>();
        ArrayList<String> invalidPhonesWithReason = new ArrayList<>();

        System.out.println("Nhập nhiều số điện thoại, cách nhau bằng dấu phẩy (,)");
        System.out.println("Ví dụ: 0912345678,0987654321,09a234, 0123456789");
        System.out.print("Nhập: ");
        String input = sc.nextLine();

        String[] parts = input.split(",");

        for (String raw : parts) {

            String phone = raw.trim();

            try {
                InvalidPhoneNumberLengthException.validate(phone);
                validPhones.add(phone);
            } catch (InvalidPhoneNumberLengthException e) {
                invalidPhonesWithReason.add(phone + " -> " + e.getMessage());
            }
        }

        System.out.println("\n=== KẾT QUẢ ===");
        System.out.println("Danh sách số điện thoại hợp lệ (" + validPhones.size() + "):");
        System.out.println(validPhones);

        System.out.println("\nDanh sách số điện thoại không hợp lệ (" + invalidPhonesWithReason.size() + "):");
        for (String s : invalidPhonesWithReason) {
            System.out.println("- " + s);
        }

        sc.close();
    }
}
