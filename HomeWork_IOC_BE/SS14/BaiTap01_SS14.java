package IOC_BE.SS14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BaiTap01_SS14 {

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhập một số nguyên dương: ");
            int n = sc.nextInt();

            if (n <= 0) {
                System.out.println("Lỗi: Số nhập vào không hợp lệ (phải > 0) để kiểm tra số nguyên tố.");
                return;
            }

            if (isPrime(n)) {
                System.out.println(n + " là số nguyên tố.");
            } else {
                System.out.println(n + " không phải là số nguyên tố.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Bạn phải nhập SỐ NGUYÊN (không nhập chữ/ký tự/số thực).");
        } finally {
            sc.close();
        }
    }
}
