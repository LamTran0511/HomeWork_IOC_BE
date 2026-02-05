package IOC_BE.SS13.BaiTap02_SS13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMenu {
    private static final AttendanceManager attendanceManager = new AttendanceManager();
    public static void showMenu(Scanner sc) {
        while (true) {
            System.out.println("""
                    -------------------STUDENT MENU------------------------
                    1. Hiển thị danh sách sinh viên
                    2. Thêm mới sinh viên
                    3. Cập nhật thông tin sinh viên
                    4. Xóa sinh viên
                    5. Thoát
                    """);
            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    showStudentMenu();
                    break;
                case 2:
                    addStudent(sc);
                    break;
                case 3:
                    updateStudent(sc);
                    break;
                case 4:
                    deleteStudent(sc);
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình");
                    sc.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }


    //    hiển thị
    private static void showStudentMenu() {
        List<Student> list = attendanceManager.display();
        if (list.isEmpty()) {
            System.out.println("Danh sách rỗng");
        } else  {
            System.out.println("\nDanh sách sinh viên");
            for (Student student : list) {
                student.displayData();
            }
        }
        System.out.println("\n\n");
    }


    //    thêm
    private static void addStudent(Scanner sc) {
        Student student = new Student();
        student.setId(findMaxId() + 1);

        String name;
        do {
            System.out.print("Nhập tên học sinh cần thêm: ");
            name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("❌ Không được để trống trường này!");
            }
        } while (name.isEmpty());
        student.setName(name);


        String email;
        do {
            System.out.print("Nhập Email: ");
            email = sc.nextLine().trim();
            if (email.isEmpty()) {
                System.out.println("❌ Không được để trống trường này!");
            }
        } while (email.isEmpty());
        student.setEmail(email);

        attendanceManager.add(student);
        System.out.println("Thêm thành công sinh viên \n\n");

    }

    //    sửa
    private static void updateStudent(Scanner sc) {
        System.out.println("Nhập id học sinh cần sửa: ");
        int id = Integer.parseInt(sc.nextLine());

        boolean find = false;
        for (Student student : attendanceManager.display()) {
            if (student.getId() == id) {
                find = true;
            }
        }
        if (find) {
            System.out.println("Sửa sinh viên");
            Student student = new Student();

            student.setId(id);

            String name;
            do {
                System.out.print("Nhập tên: ");
                name = sc.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("❌ Không được để trống trường này!");
                }
            } while (name.isEmpty());
            student.setName(name);


            String email;
            do {
                System.out.print("Nhập Email: ");
                email = sc.nextLine().trim();
                if (email.isEmpty()) {
                    System.out.println("❌ Không được để trống trường này!");
                }
            } while (email.isEmpty());
            student.setEmail(email);

            attendanceManager.update(id, student);
            System.out.println("Sửa thành công sinh viên \n\n");
        } else {
            System.out.println("❌ Không tìm thấy sinh viên có id này!");
        }
    }


    //    xoá
    private static void deleteStudent(Scanner sc) {
        System.out.print("Nhập id học sinh cần xoá: ");
        int id = Integer.parseInt(sc.nextLine());

        boolean find = false;
        for (Student student : attendanceManager.display()) {
            if (student.getId() == id) {
                attendanceManager.delete(id);
                find = true;
                System.out.println("✅ Xoá học sinh thành công!");
                break;
            }
        }
        if (!find) {
            System.out.println("❌ Không tìm thấy sinh viên có id này!");
        }
    }

    //    lấy ra id lớn nhất
    private static int findMaxId() {
        int maxId = 0;
        for (Student student : attendanceManager.display()) {
            if (student.getId() > maxId) {
                maxId = student.getId();
            }
        }
        return maxId;
    }
}