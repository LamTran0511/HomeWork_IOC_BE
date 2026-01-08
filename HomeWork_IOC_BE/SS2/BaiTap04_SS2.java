import java.util.Scanner;

public class BaiTap04_SS2 {
    static void main(String[] args) {
//        Kiểm tra dữ liệu đầu vào:
//Sử dụng câu lệnh điều kiện để xác định tính hợp lệ của tam giác. Khi tổng 2 cạnh bất kì lớn hơn cạnh thứ 3 thì đó là một tam giác,
// ngược lại thì thông báo "Ba cạnh không tạo thành tam giác.”.
//        Phân loại tam giác:
//        Sử dụng if-else để xác định loại tam giác
//        Thứ tự kiểm tra:
//        Tam giác đều
//        Tam giác cân
//        Tam giác vuông
//        Tam giác thường
//        Hiển thị kết quả:
//        Hiển thị loại tam giác
//        Hiển thị thông báo lỗi rõ ràng nếu không phải tam giác
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập cạnh a: ");
        double a = sc.nextDouble();
        System.out.print("Nhập cạnh b: ");
        double b = sc.nextDouble();
        System.out.print("Nhập cạnh c: ");
        double c = sc.nextDouble();

        // 1. Kiểm tra có phải tam giác không
        if (a + b > c && a + c > b && b + c > a) {

            // 2. Phân loại tam giác
            if (a == b && b == c) {
                System.out.println("Đây là tam giác đều");
            }
            else if (a == b || a == c || b == c) {
                System.out.println("Đây là tam giác cân");
            }
            else if (a*a + b*b == c*c ||
                    a*a + c*c == b*b ||
                    b*b + c*c == a*a) {
                System.out.println("Đây là tam giác vuông");
            }
            else {
                System.out.println("Đây là tam giác thường");
            }

        } else {
            System.out.println("Ba cạnh không tạo thành tam giác");
        }
    }
}
