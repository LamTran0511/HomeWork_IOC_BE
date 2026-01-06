import java.util.Scanner;

public class BaiTap02 {
    static void main(String[] args) {
//        Khai báo 2 biến kiểu số nguyên int và nhập giá trị :
//        Khai báo hai số nguyên firstNumber và secondNumber có kiểu int
//        Nhập các giá trị bất kỳ cho 2 biến
//        Thực hiện các phép toán:
//        Tính tổng của firstNumber và secondNumber và gán cho
//        Tính hiệu của firstNumber và secondNumber
//        Tính tích của firstNumber và secondNumber
//        Tính thương của firstNumber chia cho secondNumber
//        Tính phần dư khi chia firstNumber cho secondNumber
//        In giá trị 2 biến firstNumber, secondNumber và kết quả các phép tính ra màn hình
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số liệu một");
        int FirstNumber = sc.nextInt();
        System.out.println("Nhập số liệu hai");
        int SecondNumber = sc.nextInt();

        int tong = FirstNumber + SecondNumber;
        int hieu = FirstNumber - SecondNumber;
        int tich = FirstNumber * SecondNumber;
        int thuong = FirstNumber / SecondNumber;
        int phandu = FirstNumber % SecondNumber;

        System.out.println("\n---Kết Quả---");
        System.out.println("First Number: " + FirstNumber);
        System.out.println("Second Number: " + SecondNumber);
        System.out.println("Tổng: " + tong);
        System.out.println("Hiệu: " + hieu);
        System.out.println("Tích: " + tich);
        System.out.println("Thương: " + thuong);
        System.out.println("Phần dư: " + phandu);
    }
}