import java.util.Scanner;

public class LuyenTap01_SS3 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Tên khách hàng: ");
        String name = sc.nextLine();
        System.out.print("Tên sản phẩm: ");
        String category = sc.nextLine();
        System.out.print("Giá sản phẩm: ");
        Float price = sc.nextFloat();
        System.out.print("Số lượng mua: ");
        int quantity = sc.nextInt();
        System.out.print("Khách có thẻ thành viên? (true/false) : ");
        Boolean card = sc.nextBoolean();
        double thanhtien = price * quantity;
        double giamgia = 0;
        if (card = true) {
            giamgia = thanhtien * 0.10;
        }
        double vat = (thanhtien - giamgia) * 0.08;
        double tongthanhtoan = thanhtien - giamgia + vat;
        System.out.print("\n------Hóa Đơn------\n");
        System.out.print("\nKhách Hàng: " + name);
        System.out.print("\nSản phẩm: " + category);
        System.out.print("\nGiá: " + price);
        System.out.print("\nSố lượng: " + quantity);
        System.out.print("\nThành tiền: " + thanhtien);
        System.out.print("\nGiảm giá: " + giamgia);
        System.out.print("\nTiền VAT: " + vat);
        System.out.print("\nTổng tiền thanh toán: " + tongthanhtoan);

    }
}
