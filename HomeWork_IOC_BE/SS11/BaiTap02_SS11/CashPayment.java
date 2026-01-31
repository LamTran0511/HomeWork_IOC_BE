package IOC_BE.SS11.BaiTap02_SS11;

public class CashPayment extends Payment {

    public CashPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Thanh toán tiền mặt.");
        printAmount();
    }
}
