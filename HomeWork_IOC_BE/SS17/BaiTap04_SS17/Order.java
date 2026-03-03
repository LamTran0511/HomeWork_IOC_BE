package IOC_BE.SS17.BaiTap04_SS17;




public class Order {
    private int id;
    private int customerId;
    private String orderDate;
    private double totalAmount;

    public Order(int customerId, String orderDate, double totalAmount) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", customerId=" + customerId + ", orderDate=" + orderDate + ", totalAmount="
                + totalAmount + "]";
    }
}
