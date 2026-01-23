package SS7.BaiTapKha2_SS7;

import java.util.ArrayList;
import java.util.List;

public class BaiTapKha2_SS7_Category {
    private String id;
    private String name;
    private final List<BaiTapKha2_SS7_Product> products = new ArrayList<>();


    public BaiTapKha2_SS7_Category() {

    }

    public BaiTapKha2_SS7_Category(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addProduct(BaiTapKha2_SS7_Product p) {
        if (p == null) return;
        products.add(p);
    }
    public void removeProduct(BaiTapKha2_SS7_Product p) {
        if (p == null) return;
        products.remove(p);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<BaiTapKha2_SS7_Product> getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
