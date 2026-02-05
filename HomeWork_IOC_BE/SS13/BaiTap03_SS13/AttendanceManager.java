package IOC_BE.SS13.BaiTap03_SS13;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AttendanceManager implements Manage<Invoice> {
    private final List<Invoice> invoices = new ArrayList<>();

    @Override
    public void add(Invoice invoice) {
        invoices.add(invoice);
    }

    @Override
    public void update(int id, Invoice invoice) {
        invoices.set(findIndex(id), invoice);
    }

    @Override
    public void delete(int id) {
        invoices.remove(findIndex(id));
    }

    @Override
    public List<Invoice> display() {
        return invoices;
    }

    private int findIndex(int id) {
        for (int i = 0; i < invoices.size(); i++) {
            if(invoices.get(i).getIdInvoice()==id) {
                return i;
            }
        }
        return -1;
    }
}
