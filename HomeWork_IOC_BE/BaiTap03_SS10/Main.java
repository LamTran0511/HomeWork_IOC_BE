package SS10.BaiTap03_SS10;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();

        double basePrice = 10000;
        double tax = 1000;
        double discount = 10;

        double p1 = computer.calculatePrice(basePrice);
        System.out.println("Final price = " + p1);

        double p2 = computer.calculatePrice(basePrice, tax);
        System.out.println("Final price = " + p2);

        double p3 = computer.calculatePrice(basePrice, tax, discount);
        System.out.println("Final price = " + p3);
    }
}
