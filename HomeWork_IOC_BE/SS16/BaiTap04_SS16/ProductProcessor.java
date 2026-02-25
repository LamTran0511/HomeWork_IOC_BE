package IOC_BE.SS16.BaiTap04_SS16;

import java.util.List;

public interface ProductProcessor {
    // abstract method
    double calculateTotalValue(List<Product> products);

    // static method
    static void printProductList(List<Product> products) {
        if (products == null || products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }
        System.out.println("---- DANH SÁCH SẢN PHẨM ----");
        for (Product p : products) { // for-each
            System.out.println(p);
        }
    }

    // default method
    default boolean hasExpensiveProduct(List<Product> products) {
        if (products == null || products.isEmpty()) return false;
        for (Product p : products) { // for-each
            if (p.getPrice() > 100) return true;
        }
        return false;
    }
}