package IOC_BE.SS13.BaiTap03_SS13;

import java.util.List;
import java.util.Scanner;

public class InvoiceMenu {
    private static final AttendanceManager attendanceManager = new AttendanceManager();

    public static void showMenu(Scanner sc) {
        while (true) {
            System.out.println("""
                    -------------------INVOICE MENU------------------------
                    1. Hiển thị danh sách hóa đơn
                    2. Thêm mới hóa đơn
                    3. Cập nhật hóa đơn
                    4. Xóa hóa đơn
                    5. Thoát
                    """);
            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    showInvoiceList();
                    break;
                case 2:
                    addInvoice(sc);
                    break;
                case 3:
                    updateInvoice(sc);
                    break;
                case 4:
                    deleteInvoice(sc);
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình");
                    sc.close();
                    return;
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ!");
            }
        }
    }

    // hiển thị
    private static void showInvoiceList() {
        List<Invoice> list = attendanceManager.display();
        if (list.isEmpty()) {
            System.out.println("Danh sách hóa đơn rỗng");
        } else {
            System.out.println("\nDanh sách hóa đơn:");
            for (Invoice invoice : list) {
                invoice.displayData();
            }
        }
        System.out.println("\n");
    }

    // thêm
    private static void addInvoice(Scanner sc) {
        Invoice invoice = new Invoice();
        invoice.setIdInvoice(findMaxId() + 1);

        double amount;
        while (true) {
            try {
                System.out.print("Nhập số tiền hóa đơn: ");
                amount = Double.parseDouble(sc.nextLine());
                if (amount <= 0) {
                    System.out.println("❌ Số tiền phải lớn hơn 0!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui lòng nhập số hợp lệ!");
            }
        }

        invoice.setAmount(amount);
        attendanceManager.add(invoice);
        System.out.println("✅ Thêm hóa đơn thành công!\n");
    }

    // sửa
    private static void updateInvoice(Scanner sc) {
        System.out.print("Nhập ID hóa đơn cần sửa: ");
        int id = Integer.parseInt(sc.nextLine());

        boolean find = false;
        for (Invoice invoice : attendanceManager.display()) {
            if (invoice.getIdInvoice() == id) {
                find = true;
                break;
            }
        }

        if (find) {
            Invoice invoice = new Invoice();
            invoice.setIdInvoice(id);

            double amount;
            while (true) {
                try {
                    System.out.print("Nhập số tiền mới: ");
                    amount = Double.parseDouble(sc.nextLine());
                    if (amount <= 0) {
                        System.out.println("❌ Số tiền phải lớn hơn 0!");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("❌ Vui lòng nhập số hợp lệ!");
                }
            }

            invoice.setAmount(amount);
            attendanceManager.update(id, invoice);
            System.out.println("✅ Cập nhật hóa đơn thành công!\n");
        } else {
            System.out.println("❌ Không tìm thấy hóa đơn có ID này!");
        }
    }

    // xóa
    private static void deleteInvoice(Scanner sc) {
        System.out.print("Nhập ID hóa đơn cần xóa: ");
        int id = Integer.parseInt(sc.nextLine());

        boolean find = false;
        for (Invoice invoice : attendanceManager.display()) {
            if (invoice.getIdInvoice() == id) {
                attendanceManager.delete(id);
                find = true;
                System.out.println("✅ Xóa hóa đơn thành công!");
                break;
            }
        }

        if (!find) {
            System.out.println("❌ Không tìm thấy hóa đơn có ID này!");
        }
    }

    // lấy id lớn nhất
    private static int findMaxId() {
        int maxId = 0;
        for (Invoice invoice : attendanceManager.display()) {
            if (invoice.getIdInvoice() > maxId) {
                maxId = invoice.getIdInvoice();
            }
        }
        return maxId;
    }
}