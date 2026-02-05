package IOC_BE.SS13.BaiTap01_SS13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //   tạo danh sách người dùng
    private static List<Person>  people = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("""
                    ******************** Menu quản lý người dùng ********************
                    1. Thêm người dùng
                    2. Xoá người dùng
                    3. Hiển thị danh sách người dùng
                    4. Thoát
                    """);
            System.out.print("Lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addPerson(sc);
                    break;
                case 2:
                    deletePerson(sc);
                    break;
                case 3:
                    showPerson();
                    break;
                case 4:
                    System.out.println("Kết thúc chương trình");
                    sc.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    private static void addPerson(Scanner sc) {
        Person person = new Person();
        // NAME
        String name;
        do {
            System.out.print("Nhập tên người muốn thêm: ");
            name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("❌ Tên không được để trống!");
            }
        } while (name.isEmpty());
        person.setName(name);

        // EMAIL
        String email;
        do {
            System.out.print("Nhập email: ");
            email = sc.nextLine().trim();
            if (email.isEmpty()) {
                System.out.println("❌ Email không được để trống!");
            }
        } while (email.isEmpty());
        person.setEmail(email);

        // PHONE
        String phone;
        do {
            System.out.print("Nhập số điện thoại: ");
            phone = sc.nextLine().trim();
            if (phone.isEmpty()) {
                System.out.println("❌ Số điện thoại không được để trống!");
            }
        } while (phone.isEmpty());
        person.setPhoneNumber(phone);

        people.add(person);

        System.out.printf("Thêm thành công người dùng có tên: %s, email: %s, số điện thoại: %s",name, email, phone);
        System.out.println("\n");
    }

    private static void deletePerson(Scanner sc) {
        System.out.print("Nhập email người cần xoá: ");
        String email = sc.nextLine().trim();

        boolean tmp = false;
        for (Person person : people) {
//            kiểm tra xem người dùng có email == email nhập vào ko
            if (person.getEmail().equals(email)) {
//                nếu == thì xoá
                people.remove(person);
                tmp = true;
                System.out.println("✅ Xoá người dùng thành công!");
                break;
            }
        }
        if (!tmp) {
            System.out.println("❌ Không tìm thấy người dùng với email này!");
        }
    }

    private static void showPerson() {
        if (people.size() == 0) {
            System.out.println("Danh sách rỗng");
        } else {
            for (Person person : people) {
                System.out.println(person);
            }
        }
    }
}