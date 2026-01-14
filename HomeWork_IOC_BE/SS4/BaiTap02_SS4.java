import java.util.Scanner;

public class BaiTap02_SS4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số hàng của mảng: ");
        int rows = sc.nextInt();
        System.out.print("Nhập số cột của mảng: ");
        int cols = sc.nextInt();
        int[][] a = new int[rows][cols];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Phần tử [" + i + "][" + j + "]: ");
                a[i][j] = sc.nextInt();
            }
        }
        int sumc = 0;
        int suml = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (a[i][j] % 2 == 0) sumc += a[i][j];
                else suml += a[i][j];
            }
        }
        System.out.println("Tổng các số chẵn: " + sumc);
        System.out.println("Tổng các số lẻ: " + suml);

        sc.close();
    }
}
