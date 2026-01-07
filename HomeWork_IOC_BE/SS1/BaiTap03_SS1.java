import java.util.Scanner;

public class BaiTap03 {
    public static void main(String[] args) {
//        Viết chương trình yêu cầu người dùng nhập vào hai phân số và tính tổng của chúng
//        Yêu cầu:
//        Nhập tử số và mẫu số của hai phân số từ người dùng
//        Sử dụng biến để lưu trữ tử số và mẫu số
//        Tính tổng của hai phân số theo công thức
//        In kết quả ra màn hình dưới dạng phân số (a/b).
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tử thứ nhất =");
        double a = sc.nextDouble();
        System.out.println("Nhập mẫu thứ nhất =");
        double b = sc.nextDouble();
        System.out.println("Nhập tử thứ hai =");
        double c = sc.nextDouble();
        System.out.println("Nhập mẫu thứ hai =");
        double d = sc.nextDouble();
        double TongTu = a * d +  b * c;
        double MauTu = b * d;
        System.out.println("\n---Kết Quả---");
        System.out.println("Phân số thứ nhất"+ a +"/"+b);
        System.out.println("Phân số thứ hai"+ c +"/"+d);
        System.out.println("Kết quả"+ TongTu +"/" + MauTu);
    }

}
