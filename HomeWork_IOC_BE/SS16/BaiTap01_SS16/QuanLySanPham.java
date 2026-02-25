package IOC_BE.SS16.BaiTap01_SS16;

import java.util.*;
import java.util.stream.Collectors;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return String.format("Product{id=%d, name='%s', price=%.2f}", id, name, price);
    }
}

public class QuanLySanPham {
    private static final Scanner sc = new Scanner(System.in);
    private static final HashMap<Integer, Product> products = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = readInt("Chọn chức năng: ");

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> updateProduct();
                case 3 -> deleteProduct();
                case 4 -> showProducts();
                case 5 -> filterProductsPriceGreaterThan100();
                case 6 -> totalPrice();
                case 0 -> {
                    System.out.println("Thoát chương trình.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("===== QUẢN LÝ SẢN PHẨM (HashMap + Streams) =====");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Sửa sản phẩm");
        System.out.println("3. Xóa sản phẩm");
        System.out.println("4. Hiển thị danh sách");
        System.out.println("5. Lọc sản phẩm (price > 100)");
        System.out.println("6. Tính tổng giá trị sản phẩm");
        System.out.println("0. Thoát");
    }

    // ===== CRUD =====

    private static void addProduct() {
        int id = readInt("Nhập id: ");
        if (products.containsKey(id)) {
            System.out.println("❌ Id đã tồn tại. Không thể thêm.");
            return;
        }
        String name = readNonEmptyString("Nhập tên: ");
        double price = readDouble("Nhập giá: ");

        products.put(id, new Product(id, name, price));
        System.out.println("✅ Thêm sản phẩm thành công!");
    }

    private static void updateProduct() {
        int id = readInt("Nhập id cần sửa: ");
        Product p = products.get(id);
        if (p == null) {
            System.out.println("❌ Không tìm thấy sản phẩm với id = " + id);
            return;
        }

        String newName = readNonEmptyString("Nhập tên mới: ");
        double newPrice = readDouble("Nhập giá mới: ");

        p.setName(newName);
        p.setPrice(newPrice);

        System.out.println("✅ Cập nhật thành công!");
        System.out.println("Sau cập nhật: " + p);
    }

    private static void deleteProduct() {
        int id = readInt("Nhập id cần xóa: ");
        Product removed = products.remove(id);

        if (removed == null) {
            System.out.println("❌ Không tìm thấy sản phẩm để xóa.");
        } else {
            System.out.println("✅ Đã xóa: " + removed);
        }
    }

    private static void showProducts() {
        if (products.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }

        System.out.println("---- Danh sách sản phẩm ----");
        // In đẹp + có sắp xếp theo id (tùy chọn)
        products.values().stream()
                .sorted(Comparator.comparingInt(Product::getId))
                .forEach(System.out::println);
    }

    // ===== Streams =====

    private static void filterProductsPriceGreaterThan100() {
        List<Product> result = products.values().stream()
                .filter(p -> p.getPrice() > 100)
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không có sản phẩm nào có price > 100.");
            return;
        }

        System.out.println("---- Sản phẩm có price > 100 ----");
        result.forEach(System.out::println);
    }

    private static void totalPrice() {
        double sum = products.values().stream()
                .mapToDouble(Product::getPrice)
                .sum();

        System.out.printf("Tổng giá trị danh sách sản phẩm: %.2f%n", sum);
    }

    // ===== Helpers nhập liệu =====

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                double v = Double.parseDouble(s);
                if (v < 0) {
                    System.out.println("⚠️ Giá không được âm.");
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Vui lòng nhập số thực hợp lệ.");
            }
        }
    }

    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("⚠️ Không được để trống.");
        }
    }
}