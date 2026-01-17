import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class BaiTap04_SS5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Nhập vào độ dài chuỗi ngẫu nhiên: ");
        int n = sc.nextInt();

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = ThreadLocalRandom.current().nextInt(chars.length());
            result.append(chars.charAt(index));
        }

        System.out.println("Chuỗi ngẫu nhiên: " + result.toString());
        }

    }
