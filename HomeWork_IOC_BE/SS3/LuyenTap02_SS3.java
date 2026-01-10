import java.util.ArrayList;
import java.util.Scanner;

public class LuyenTap02_SS3 {

    static ArrayList<Double> danhSachDiem = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            hienThiMenu();
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    nhapDiemHocVien(sc);
                    break;
                case 2:
                    hienThiThongKe();
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (true);
    }

    // ===== MENU =====
    static void hienThiMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Nhập điểm học viên");
        System.out.println("2. Hiển thị thống kê");
        System.out.println("3. Thoát");
    }

    // ===== CHỨC NĂNG 1 =====
    static void nhapDiemHocVien(Scanner sc) {
        System.out.println("\n--- Nhập điểm học viên (nhập -1 để dừng) ---");

        while (true) {
            System.out.print("Nhập điểm: ");
            double diem = sc.nextDouble();

            if (diem == -1) {
                break;
            }

            if (diem < 0 || diem > 10) {
                System.out.println("Điểm không hợp lệ. Nhập lại.");
                continue;
            }

            danhSachDiem.add(diem);
            System.out.println("Học lực: " + xepLoaiHocLuc(diem));
        }
    }

    // ===== XẾP LOẠI =====
    static String xepLoaiHocLuc(double diem) {
        if (diem < 5)
            return "Yếu";
        else if (diem < 7)
            return "Trung bình";
        else if (diem < 8)
            return "Khá";
        else if (diem < 9)
            return "Giỏi";
        else
            return "Xuất sắc";
    }

    // ===== CHỨC NĂNG 2 =====
    static void hienThiThongKe() {
        if (danhSachDiem.isEmpty()) {
            System.out.println("Chưa có dữ liệu.");
            return;
        }

        double tong = 0;
        double max = danhSachDiem.get(0);
        double min = danhSachDiem.get(0);

        for (double d : danhSachDiem) {
            tong += d;
            if (d > max) max = d;
            if (d < min) min = d;
        }

        double trungBinh = tong / danhSachDiem.size();

        System.out.println("\n--- KẾT QUẢ ---");
        System.out.println("Số học viên đã nhập: " + danhSachDiem.size());
        System.out.printf("Điểm trung bình: %.2f\n", trungBinh);
        System.out.printf("Điểm cao nhất: %.2f\n", max);
        System.out.printf("Điểm thấp nhất: %.2f\n", min);
    }
}
