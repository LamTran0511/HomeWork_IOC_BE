package SS10.BaiTap03_SS10;

public class Computer {
    public double calculatePrice(double basePrice) {
        System.out.println("[Chỉ tính theo giá gốc]");
        return basePrice;
    }
    public double calculatePrice(double basePrice, double tax) {
        System.out.println("[Tính theo giá gốc + thuế]");
        return basePrice + tax;
    }
    public double calculatePrice(double basePrice, double tax, double discount) {
        System.out.println("[Tính theo giá gốc + thuế + giảm giá]");
        return basePrice + tax + discount;
    }



}
