package IOC_BE.SS17.BaiTap02_SS17;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

import IOC_BE.SS17.ConnectionDB;

public class TaskManagement {
    public void addTask(Scanner scanner) {
        Task task = new Task();
        task.inputData(scanner);
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall("{call ex2.add_task(?, ?)}")) {
            stmt.setString(1, task.getTaskName());
            stmt.setString(2, task.getStatus());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm công việc vào cơ sở dữ liệu: " + e.getMessage());
        }
    }

    public void getTaskByName(Scanner scanner) {
        System.out.print("Nhập tên công việc cần tìm: ");
        String taskName = scanner.nextLine();
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall("{call ex2.get_task_by_name(?)}")) {
            stmt.setString(1, taskName);
            java.sql.ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setTaskName(rs.getString("task_name"));
                task.setStatus(rs.getString("status"));
                System.out.println("Công việc tìm thấy: ");
                System.out.println("+-----+--------------------------------------------------+------------------------------+");
                System.out.println(task);
                System.out.println("+-----+--------------------------------------------------+------------------------------+");
            } else {
                System.out.println("Không tìm thấy công việc với tên: " + taskName);
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi tìm kiếm công việc: " + e.getMessage());
        }
    }

    public void listTasks() {
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall("{call ex2.list_tasks()}")) {
            java.sql.ResultSet rs = stmt.executeQuery();
            System.out.println("+-----+--------------------------------------------------+------------------------------+");
            System.out.println("|ID   |Task Name                                         |Status                        |");
            System.out.println("+-----+--------------------------------------------------+------------------------------+");
            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setTaskName(rs.getString("task_name"));
                task.setStatus(rs.getString("status"));
                System.out.println(task);
            }
            System.out.println("+-----+--------------------------------------------------+------------------------------+");
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị danh sách công việc: " + e.getMessage());
        }
    }

    public void updateTaskStatus(Scanner scanner) {
        int id = 0;
        while (true) {
            try {
                System.out.print("Nhập ID của công việc cần cập nhật: ");
                id = Integer.parseInt(scanner.nextLine());
                if (id <= 0) {
                    throw new IllegalArgumentException("ID phải là số nguyên dương.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("ID không hợp lệ. Vui lòng nhập một số nguyên dương.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Nhập trạng thái mới cho công việc: ");
        String newStatus = scanner.nextLine();

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall("{call ex2.update_task_status(?, ?)}")) {
            stmt.setInt(1, id);
            stmt.setString(2, newStatus);
            stmt.execute();
            System.out.println("Cập nhật trạng thái công việc thành công.");
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật trạng thái công việc: " + e.getMessage());
        }
    }

    public void deleteTask(Scanner scanner) {
        int id = 0;
        while (true) {
            try {
                System.out.print("Nhập ID của công việc cần xóa: ");
                id = Integer.parseInt(scanner.nextLine());
                if (id <= 0) {
                    throw new IllegalArgumentException("ID phải là số nguyên dương.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("ID không hợp lệ. Vui lòng nhập một số nguyên dương.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall("{call ex2.delete_task(?)}")) {
            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("Xóa công việc thành công.");
        } catch (Exception e) {
            System.out.println("Lỗi khi xóa công việc: " + e.getMessage());
        }
    }

    public void taskStatistics() {
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall("{call ex2.task_statistics()}")) {
            java.sql.ResultSet rs = stmt.executeQuery();
            System.out.println("+------------------------------+------------------------------+");
            System.out.println("|Status                        |Count                         |");
            System.out.println("+------------------------------+------------------------------+");
            while (rs.next()) {
                String status = rs.getString("status");
                int count = rs.getInt("count");
                System.out.printf("|%-30s|%-30d|\n", status, count);
            }
            System.out.println("+------------------------------+------------------------------+");
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị thống kê công việc: " + e.getMessage());
        }
    }
}