import java.util.Scanner;

public class BaiTap01_SS4 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Khởi Tạo Mảng:
//        Người dùng nhập kích thước của mảng
//        Người dùng nhập từng giá trị cho mảng số nguyên
//        Sắp Xếp:
//        Sử dụng thuật toán sắp xếp nổi bọt để sắp xếp mảng theo thứ tự giảm dần
//        Đầu Ra:
//        Hiển thị mảng đã sắp xếp
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = sc.nextInt();

        int[] a = new int[n];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // tối ưu: nếu không đổi chỗ thì dừng sớm
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] < a[j + 1]) { // đổi dấu để sort giảm dần
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        System.out.println("Mảng sau khi sắp xếp giảm dần:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + (i == n - 1 ? "" : " "));
        }

        sc.close();
    }
}
