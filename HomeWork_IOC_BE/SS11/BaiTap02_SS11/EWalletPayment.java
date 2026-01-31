package IOC_BE.SS11.BaiTap02_SS11;

public class EWalletPayment extends Payment implements Refundable {
    private String walletName; // ví dụ: Momo, ZaloPay...

    public EWalletPayment(double amount, String walletName) {
        super(amount);
        this.walletName = walletName;
    }

    @Override
    public void pay() {
        System.out.println("Thanh toán ví điện tử: " + walletName);
        printAmount();
    }

    @Override
    public void refund() {
        System.out.println("Hoàn tiền về ví điện tử: " + walletName);
        printAmount();
    }
}
