package IOC_BE.SS14;

import java.util.Scanner;

public class BaiTap03_SS14 {

    public static void main(String[] args) {
        final long INITIAL_BALANCE = 1_000_000;
        final long MIN_BALANCE = 50_000;

        long balance = INITIAL_BALANCE;
        Scanner sc = new Scanner(System.in);

        System.out.println("=== CHƯƠNG TRÌNH RÚT TIỀN ===");
        System.out.println("Số dư hiện tại: " + balance + " đồng");
        System.out.println("Số dư tối thiểu phải duy trì: " + MIN_BALANCE + " đồng");

        while (true) {
            System.out.print("\nNhập số tiền muốn rút: ");
            String input = sc.nextLine().trim();

            try {
                long withdraw = Long.parseLong(input);

                if (withdraw <= 0) {
                    System.out.println("Lỗi: Số tiền rút phải > 0!");
                    continue;
                }

                if (withdraw > balance) {
                    System.out.println("Lỗi: Số tiền rút vượt quá số dư!");
                    continue;
                }

                if (balance - withdraw < MIN_BALANCE) {
                    System.out.println("Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
                    continue;
                }

                balance -= withdraw;
                System.out.println("Rút tiền thành công!");
                System.out.println("Số tiền đã rút: " + withdraw + " đồng");
                System.out.println("Số dư còn lại: " + balance + " đồng");
                break;

            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
            }
        }

        sc.close();
    }
}
