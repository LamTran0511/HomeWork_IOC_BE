import java.util.Scanner;

public class BaiTap04_SS1 {
    static void main(String[] args) {
//        Khai báo 2 biến width và height có kiểu float lần lượt là 2 chiều rộng và chiều cao, 2 biến area và  perimeter có kiểu float lần lượt là diện tích và chu vi hình chữ nhật
//        Nhập dữ liệu
//        Nhập chiều dài và chiều rộng của hình chữ nhật từ bàn phím
//        Tính diện tích và chu vi:
//        Sử dụng công thức để tính diện tích và chu vi của hình chữ nhật và lưu giá trị tính toán vào 2 biến diện tích và chu vi
//        In kết quả diện tích và chu vi của hình chữ nhật lên màn hình`
        Scanner sc = new Scanner(System.in);
        System.out.println("Chiều rộng =");
        float width = sc.nextFloat();
        System.out.println("Chiều cao =");
        float height = sc.nextFloat();
        float area = width*height;
        float perimeter = 2*(width+height);
        System.out.println("Diện tích ="+area);
        System.out.println("Chu vi ="+perimeter);
    }
}
