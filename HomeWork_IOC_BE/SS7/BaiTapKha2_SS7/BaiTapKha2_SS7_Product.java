package SS7.BaiTapKha2_SS7;

public class BaiTapKha2_SS7_Product {
    private String id;
    private String name;
    private double price;

    public BaiTapKha2_SS7_Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getInfo() {
        return "Product{id='" + id + "', name='" + name + "', price=" + price + "}";
    }
}
