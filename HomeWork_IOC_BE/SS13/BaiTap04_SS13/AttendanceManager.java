package IOC_BE.SS13.BaiTap04_SS13;

import java.util.ArrayList;
import java.util.List;

public class AttendanceManager implements Manage<Order> {
    private final List<Order> orders = new ArrayList<>();

    @Override
    public void add(Order oder) {
        orders.add(oder);
    }

    @Override
    public void update(int id, Order oder) {
        orders.set(findIndex(id), oder);
    }

    @Override
    public void delete(int id) {
        orders.remove(findIndex(id));
    }

    @Override
    public List<Order> display() {
        return orders;
    }

    //    lấy index dựa trên id truyền vào
    private int findIndex(int id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOderId() == id) {
                return i;
            }
        }
        return -1;
    }
}