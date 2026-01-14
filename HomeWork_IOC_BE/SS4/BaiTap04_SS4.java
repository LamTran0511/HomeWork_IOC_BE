import java.util.Scanner;

public class BaiTap04_SS4 {
    static int[] stableEvenOdd(int[] a) {
        Scanner sc = new Scanner(System.in);
        int n = a.length;
        int[] res = new int[n];
        int k = 0;

        // đưa các số chẵn vào trước (giữ thứ tự)
        for (int x : a) {
            if (x % 2 == 0) {
                res[k++] = x;
            }
        }

        // đưa các số lẻ vào sau (giữ thứ tự)
        for (int x : a) {
            if (x % 2 != 0) {
                res[k++] = x;
            }
        }

        return res;
    }

    static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + (i == a.length - 1 ? "" : " "));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();

        // Nếu mảng không hợp lệ (kích thước 0)
        if (n <= 0) {
            System.out.println("Mảng không có phần tử");
            return;
        }

        int[] a = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            a[i] = sc.nextInt();
        }

        int[] sorted = stableEvenOdd(a);

        System.out.println("Mảng sau khi sắp xếp:");
        printArray(sorted);
    }
}