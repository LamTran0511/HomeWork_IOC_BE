package IOC_BE.SS13.BaiTap04_SS13;

import java.util.List;
import java.util.Scanner;

public class OrderMenu {
    private static final AttendanceManager attendanceManager = new AttendanceManager();

    public static void showMenu(Scanner sc) {
        while (true) {
            System.out.println("""
                    -------------------ORDER MENU------------------------
                    1. Hiển thị danh sách đơn hàng
                    2. Thêm mới đơn hàng
                    3. Cập nhật đơn hàng
                    4. Xóa đơn hàng
                    5. Thoát
                    """);
            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    showOrderList();
                    break;
                case 2:
                    addOrder(sc);
                    break;
                case 3:
                    updateOrder(sc);
                    break;
                case 4:
                    deleteOrder(sc);
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
    private static void showOrderList() {
        List<Order> list = attendanceManager.display();
        if (list.isEmpty()) {
            System.out.println("Danh sách đơn hàng rỗng");
        } else {
            System.out.println("\nDanh sách đơn hàng:");
            for (Order order : list) {
                order.displayData();
            }
        }
        System.out.println("\n");
    }

    // thêm
    private static void addOrder(Scanner sc) {
        Order order = new Order();
        order.setOderId(findMaxId() + 1);

        String customerName;
        do {
            System.out.print("Nhập tên khách hàng: ");
            customerName = sc.nextLine().trim();
            if (customerName.isEmpty()) {
                System.out.println("❌ Không được để trống!");
            }
        } while (customerName.isEmpty());

        order.setCustomerName(customerName);
        attendanceManager.add(order);
        System.out.println("✅ Thêm đơn hàng thành công!\n");
    }

    // sửa
    private static void updateOrder(Scanner sc) {
        System.out.print("Nhập ID đơn hàng cần sửa: ");
        int id = Integer.parseInt(sc.nextLine());

        boolean find = false;
        for (Order order : attendanceManager.display()) {
            if (order.getOderId() == id) {
                find = true;
                break;
            }
        }

        if (find) {
            Order order = new Order();
            order.setOderId(id);

            String customerName;
            do {
                System.out.print("Nhập tên khách hàng mới: ");
                customerName = sc.nextLine().trim();
                if (customerName.isEmpty()) {
                    System.out.println("❌ Không được để trống!");
                }
            } while (customerName.isEmpty());

            order.setCustomerName(customerName);
            attendanceManager.update(id, order);
            System.out.println("✅ Cập nhật đơn hàng thành công!\n");
        } else {
            System.out.println("❌ Không tìm thấy đơn hàng có ID này!");
        }
    }

    // xoá
    private static void deleteOrder(Scanner sc) {
        System.out.print("Nhập ID đơn hàng cần xóa: ");
        int id = Integer.parseInt(sc.nextLine());

        boolean find = false;
        for (Order order : attendanceManager.display()) {
            if (order.getOderId() == id) {
                attendanceManager.delete(id);
                find = true;
                System.out.println("✅ Xóa đơn hàng thành công!");
                break;
            }
        }

        if (!find) {
            System.out.println("❌ Không tìm thấy đơn hàng có ID này!");
        }
    }

    // lấy id lớn nhất
    private static int findMaxId() {
        int maxId = 0;
        for (Order order : attendanceManager.display()) {
            if (order.getOderId() > maxId) {
                maxId = order.getOderId();
            }
        }
        return maxId;
    }
}