package SS9.LT1_SS9;

public class Rectangle {
    private double width;
    private double height;

    //    hàm khởi tạo
    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    //    getter setter
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


//    getArea() — trả về width * height
//    getPerimeter() — trả về 2 * (width + height)
//    toString() (khuyến nghị) — trả về chuỗi mô tả như: "Rectangle(width=..., height=..., area=..., perimeter=...)"

    public double getArea() {
        return width * height;
    }
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return ("Rectangle(Width = " + this.width + ", Height = " + this.height + ", Area = " + this.getArea() + ", Perimeter = " + this.getPerimeter() + ")");
    }
}