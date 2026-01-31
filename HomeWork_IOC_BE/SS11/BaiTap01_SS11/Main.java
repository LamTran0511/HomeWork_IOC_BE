package IOC_BE.SS11.BaiTap01_SS11;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[] {
                new Rectangle(4, 6),
                new Circle(3),
                new Rectangle(2.5, 5),
                new Circle(1.2)
        };

        for (Shape s : shapes) {
            s.displayInfo();
            System.out.printf("Diện tích: %.2f%n", s.getArea());
            System.out.printf("Chu vi: %.2f%n", s.getPerimeter());

            // Vì s là Shape nên muốn gọi draw() (của Drawable) cần ép kiểu
            if (s instanceof Drawable) {
                ((Drawable) s).draw();
            }

            System.out.println("----------------------");
        }
    }
}
