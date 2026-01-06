import java.util.Scanner;

public class BaiTap01 {
    public static void main(String[] args) {
//        Viết chương trình yêu cầu người dùng nhập bán kính của một hình tròn , sau đó tính và hiển thị diện tích
        //        Sử dụng biến để lưu trữ bán kính (radius) của hình tròn
//        Sử dụng toán tử nhân để tính diện tích với công thức :
//        In kết quả ra màn hình
     Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ban kinh :");
        double r = sc.nextDouble();
        double A = Math.PI * Math.pow(r, 2);
        System.out.printf("Ket Qua =%f",A);
    }
}
