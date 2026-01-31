package IOC_BE.SS11.BaiTap01_SS11;

public class Circle extends Shape implements Drawable {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void draw() {
        System.out.println("Đã vẽ hình: " + name);
    }
}
