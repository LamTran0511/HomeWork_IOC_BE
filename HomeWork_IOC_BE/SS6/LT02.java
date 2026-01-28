package SS6;

import java.util.Scanner;
import java.util.regex.Pattern;

public class LT02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        boolean flagUser = false;

        // thông tin người dùng
        String fullName = "";
        String email = "";
        String phone = "";
        String password = "";

        do {
            System.out.println("""
                    
                    ******************** QUẢN LÝ NGƯỜI DÙNG ********************
                    1. Nhập thông tin người dùng
                    2. Chuẩn hóa họ tên
                    3. Kiểm tra email hợp lệ
                    4. Kiểm tra số điện thoại hợp lệ
                    5. Kiểm tra mật khẩu hợp lệ
                    6. Thoát
                    """);

            System.out.print("Nhập lựa chọn: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            // kiểm tra nhập lựa chọn
            while (choice < 1 || choice > 6) {
                System.out.print("Lựa chọn sai, vui lòng nhập lại: ");
                choice = sc.nextInt();
                sc.nextLine();
            }

            switch (choice) {
                case 1: {
                    System.out.print("Nhập họ tên: ");
                    fullName = sc.nextLine();

                    System.out.print("Nhập email: ");
                    email = sc.nextLine();

                    System.out.print("Nhập số điện thoại: ");
                    phone = sc.nextLine();

                    System.out.print("Nhập mật khẩu: ");
                    password = sc.nextLine();

                    flagUser = true;
                }
                break;

                case 2: {
                    if (!flagUser) {
                        CheckFlagUser();
                    } else {
                        fullName = normalizeName(fullName);
                        System.out.println("Họ tên sau khi chuẩn hóa: " + fullName);
                    }
                }
                break;

                case 3: {
                    if (!flagUser) {
                        CheckFlagUser();
                    } else {
                        if (checkEmail(email)) {
                            System.out.println("Email hợp lệ");
                        } else {
                            System.out.println("Email không hợp lệ");
                        }
                    }
                }
                break;

                case 4: {
                    if (!flagUser) {
                        CheckFlagUser();
                    } else {
                        if (checkPhone(phone)) {
                            System.out.println("Số điện thoại hợp lệ");
                        } else {
                            System.out.println("Số điện thoại không hợp lệ");
                        }
                    }
                }
                break;

                case 5: {
                    if (!flagUser) {
                        CheckFlagUser();
                    } else {
                        if (checkPassword(password)) {
                            System.out.println("Mật khẩu hợp lệ");
                        } else {
                            System.out.println("Mật khẩu không hợp lệ");
                        }
                    }
                }
                break;

                case 6:
                    System.out.println("Kết thúc chương trình");
                    break;

                default:
                    System.out.println("Lỗi! Không có lựa chọn này");
            }

        } while (choice != 6);
    }

    // kiểm tra đã nhập thông tin người dùng hay chưa
    public static void CheckFlagUser() {
        System.out.println("Chưa có thông tin người dùng. Vui lòng nhập trước!");
    }

    // chuẩn hóa họ tên: xóa khoảng trắng thừa, viết hoa chữ cái đầu
    public static String normalizeName(String name) {
        name = name.trim().toLowerCase();
        String[] parts = name.split("\\s+");
        String result = "";

        for (String p : parts) {
            result += Character.toUpperCase(p.charAt(0)) + p.substring(1) + " ";
        }

        return result.trim();
    }

    // kiểm tra email hợp lệ
    public static boolean checkEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(regex, email);
    }

    // kiểm tra số điện thoại Việt Nam (10 số, bắt đầu bằng 0)
    public static boolean checkPhone(String phone) {
        String regex = "0[0-9]{9}";
        return Pattern.matches(regex, phone);
    }

    // kiểm tra mật khẩu hợp lệ
    // ít nhất 8 ký tự, có chữ thường, chữ hoa, số và ký tự đặc biệt
    public static boolean checkPassword(String password) {
        if (password.length() < 8) return false;

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSpecial = true;
        }

        return hasLower && hasUpper && hasDigit && hasSpecial;
    }
}