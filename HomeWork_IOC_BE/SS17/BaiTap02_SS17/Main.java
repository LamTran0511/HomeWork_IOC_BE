package IOC_BE.SS17.BaiTap02_SS17;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManagement taskManagement = new TaskManagement();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Thêm công việc mới");
            System.out.println("2. Tìm công việc theo tên");
            System.out.println("3. Hiển thị tất cả công việc");
            System.out.println("4. Thống kê công việc theo trạng thái");
            System.out.println("5. Cập nhật trạng thái công việc");
            System.out.println("6. Xóa công việc");
            System.out.println("7. Thoát");
            System.out.print("Chọn chức năng: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    taskManagement.addTask(scanner);
                    break;
                case "2":
                    taskManagement.getTaskByName(scanner);
                    break;
                case "3":
                    taskManagement.listTasks();
                    break;
                case "4":
                    taskManagement.taskStatistics();
                    break;
                case "5":
                    taskManagement.updateTaskStatus(scanner);
                    break;
                case "6":
                    taskManagement.deleteTask(scanner);
                    break;
                case "7":
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
}
