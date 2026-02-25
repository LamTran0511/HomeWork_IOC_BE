package IOC_BE.SS16.BaiTap04_SS16;

import java.util.List;

public class ProductProcessorImpl implements ProductProcessor {

    @Override
    public double calculateTotalValue(List<Product> products) {
        if (products == null || products.isEmpty()) return 0.0;

        double sum = 0.0;
        for (Product p : products) { // for-each
            sum += p.getPrice();
        }
        return sum;

        // (Tuỳ chọn - stream)
        // return products.stream().mapToDouble(Product::getPrice).sum();
    }
}