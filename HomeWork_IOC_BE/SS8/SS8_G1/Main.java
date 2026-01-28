package SS8.SS8_G1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        run();
    }
    public static void run() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập vào số tiền cần đổi:");
        double vnd = sc.nextDouble();

        double result = SS8_G1.CurrencyConverter.toUSD(vnd);
        System.out.printf("Tiền sau khi đổi: %f", result);
    }
}