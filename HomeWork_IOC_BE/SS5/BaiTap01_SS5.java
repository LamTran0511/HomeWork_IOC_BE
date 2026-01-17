import java.util.Scanner;

public class BaiTap01_SS5 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập email: ");
        String email =  sc.nextLine().trim();

        String regex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$";
        if (email.matches(regex)) {
            System.out.println("Email hợp lệ.");
        } else {
            System.err.println("Email không hợp lệ.");
        }
    }
}
