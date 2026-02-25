package IOC_BE.SS16.BaiTap04_SS16;

public class Product {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên sản phẩm không được để trống.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Giá sản phẩm không được âm.");
        }
        this.name = name.trim();
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("Product{name='%s', price=%.2f}", name, price);
    }
}