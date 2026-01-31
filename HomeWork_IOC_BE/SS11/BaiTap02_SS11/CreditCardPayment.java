package IOC_BE.SS11.BaiTap02_SS11;

public class CreditCardPayment extends Payment implements Refundable {
    private String cardNumber;

    public CreditCardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay() {
        System.out.println("Thanh toán thẻ tín dụng.");
        printAmount();
        System.out.println("Số thẻ (ẩn): **** **** **** " + last4(cardNumber));
    }

    @Override
    public void refund() {
        System.out.println("Hoàn tiền về thẻ tín dụng: **** **** **** " + last4(cardNumber));
        printAmount();
    }

    private String last4(String s) {
        if (s == null || s.length() < 4) return "????";
        return s.substring(s.length() - 4);
    }
}
