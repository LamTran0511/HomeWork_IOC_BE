import java.util.Scanner;

public class BaiTap02_SS2 {
    static void main(String[] args) {
//        Sinh viên cần viết một chương trình Java thực hiện các nhiệm vụ sau:
//        Yêu cầu người dùng nhập một số nguyên từ 1 đến 12 (tương ứng với tháng)
//        Sử dụng cấu trúc switch-case để:
//        Hiển thị tên tháng
//        Hiển thị số ngày của tháng:
//        Tháng 1, 3, 5, 7, 8, 10, 12: có 31 ngày
//        Tháng 4, 6, 9, 11: có 30 ngày
//        Tháng 2: có 28 hoặc 29 ngày
//        Xử lý trường hợp người dùng nhập số không hợp lệ (không nằm trong khoảng 1-12) và hiển thị thông báo: "Tháng không hợp lệ.”
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tháng từ 1 đến 12: ");
        int n = sc.nextInt();
        switch(n){
            case 1,3,5,7,8,10,12: {System.out.println("Tháng có 31 ngày");}
            break;
            case 2: {System.out.println("Tháng có 28 hoặc 29 ngày");}
            break;
            case 4,6,9,11: {System.out.println("Tháng có 30 ngày");}
            break;
            default: {System.out.println("Không có tháng "+n);}
            break;
        }

    }
}
