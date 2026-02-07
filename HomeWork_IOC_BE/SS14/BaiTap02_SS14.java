package IOC_BE.SS14;

import java.util.ArrayList;
import java.util.Scanner;

public class BaiTap02_SS14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> validNumbers = new ArrayList<>();
        int invalidCount = 0;

        System.out.println("Nhập các chuỗi (gõ 'exit' để kết thúc):");

        while (true) {
            System.out.print("Nhập chuỗi: ");
            String s = sc.nextLine().trim();

            if (s.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                // Thử chuyển chuỗi sang số nguyên
                int num = Integer.parseInt(s);
                validNumbers.add(num);
            } catch (NumberFormatException e) {
                // Không chuyển được sang int
                invalidCount++;
            }
        }

        int validCount = validNumbers.size();

        System.out.println("\nSố chuỗi hợp lệ: " + validCount);
        System.out.println("Số chuỗi không hợp lệ: " + invalidCount);
        System.out.println("Danh sách số nguyên hợp lệ: " + validNumbers);

        sc.close();
    }
}
