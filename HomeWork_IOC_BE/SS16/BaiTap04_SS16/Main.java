package IOC_BE.SS16.BaiTap04_SS16;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // 1) Tạo danh sách sản phẩm
        List<Product> products = new ArrayList<>();
        products.add(new Product("Milk", 35));
        products.add(new Product("Keyboard", 120));
        products.add(new Product("Notebook", 15));
        products.add(new Product("Headphone", 250));

        // 2) Predicate lọc sản phẩm đắt tiền (> 100)
        Predicate<Product> expensiveFilter = p -> p.getPrice() > 100;

        ProductProcessor processor = new ProductProcessorImpl();

        // 3) Kiểm tra có sản phẩm > 100 hay không
        if (processor.hasExpensiveProduct(products)) {
            System.out.println("Có sản phẩm đắt tiền (> 100). Danh sách sản phẩm đắt tiền:");
            // in ra các sản phẩm đắt tiền (dùng for-each + Predicate)
            for (Product p : products) {
                if (expensiveFilter.test(p)) {
                    System.out.println(p);
                }
            }
        } else {
            System.out.println("Không có sản phẩm đắt tiền");
        }

        System.out.println();

        // 4) Tính tổng giá trị sản phẩm
        double total = processor.calculateTotalValue(products);
        System.out.printf("Tổng giá trị sản phẩm: %.2f%n", total);

        System.out.println();

        // 5) In toàn bộ danh sách bằng static method
        ProductProcessor.printProductList(products);

        System.out.println();

        // (Tuỳ chọn) stream + Predicate: lọc nhanh
        List<Product> expensiveProducts = products.stream()
                .filter(expensiveFilter)
                .toList();
        System.out.println("Stream lọc sản phẩm đắt tiền: " + expensiveProducts.size() + " sản phẩm.");
    }
}