import java.util.Scanner;

public class BaiTap03_SS2 {
    static void main(String[] args) {
//        Đầu vào:
//        Một số nguyên N, có thể âm hoặc dương, được nhập từ bàn phím.
//        Xử lý:
//        Nếu số là âm, chuyển nó thành số dương.
//        Sử dụng vòng lặp để tách từng chữ số của N (lấy phần dư khi chia 10).
//                Cộng các chữ số lại để tính tổng.
//                In ra tổng của các chữ số.
//        Đầu ra:
//        Hiển thị tổng các chữ số của N.
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số nguyên N: ");
        int n = sc.nextInt();

        if (n < 0) {
            n = -n;
        }

        int sum = 0;

        if (n == 0) {
            sum = 0;
        } else {
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
    }
        System.out.println("Tổng các chữ số là: "+sum);
}
}
