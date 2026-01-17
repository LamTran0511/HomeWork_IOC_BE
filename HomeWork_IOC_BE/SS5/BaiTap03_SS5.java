import java.util.Scanner;

public class BaiTap03_SS5 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mật khẩu: ");
        String password = sc.nextLine();
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$!%]).{8,}$";
        if (password.matches(regex)) {
            System.out.println("Mật khẩu hợp lệ.");
        } else {
            System.err.println("Mật khẩu không hợp lệ.");
        }
    }
}
