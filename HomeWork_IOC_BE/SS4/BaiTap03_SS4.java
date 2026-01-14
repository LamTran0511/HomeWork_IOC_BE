import java.util.Scanner;

public class BaiTap03_SS4 {

    static void selectionSortDesc(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] > a[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[maxIndex];
            a[maxIndex] = temp;
        }
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    static int binarySearchDesc(int[] a, int x) {
        int left = 0, right = a.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (a[mid] == x) return mid;

            if (x < a[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + (i == a.length - 1 ? "" : " "));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = sc.nextInt();

        int[] a = new int[n];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            a[i] = sc.nextInt();
        }

        selectionSortDesc(a);

        System.out.println("Mảng sau khi sắp xếp giảm dần:");
        printArray(a);

        System.out.print("Nhập số cần tìm: ");
        int x = sc.nextInt();
        int posLinear = linearSearch(a, x);
        if (posLinear != -1) {
            System.out.println("Tìm kiếm tuyến tính: Số " + x + " có tại vị trí " + (posLinear + 1));
        } else {
            System.out.println("Tìm kiếm tuyến tính: Không tìm thấy số " + x);
        }

        int posBinary = binarySearchDesc(a, x);
        if (posBinary != -1) {
            System.out.println("Tìm kiếm nhị phân: Số " + x + " có tại vị trí " + (posBinary + 1));
        } else {
            System.out.println("Tìm kiếm nhị phân: Không tìm thấy số " + x);
        }

    }
}
