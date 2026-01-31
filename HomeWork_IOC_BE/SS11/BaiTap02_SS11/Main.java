package IOC_BE.SS11.BaiTap02_SS11;

public class Main {
    public static void main(String[] args) {
        Payment[] payments = new Payment[] {
                new CashPayment(150000),
                new CreditCardPayment(500000, "1234567812345678"),
                new EWalletPayment(220000, "Momo"),
                new CashPayment(90000),
                new CreditCardPayment(1200000, "9999888877776666")
        };

        for (Payment p : payments) {
            System.out.println("----- GIAO DỊCH -----");
            p.pay();

            // Nếu đối tượng có Refundable -> gọi refund()
            if (p instanceof Refundable) {
                System.out.println(">> Giao dịch này hỗ trợ hoàn tiền.");
                ((Refundable) p).refund();
            } else {
                System.out.println(">> Giao dịch này KHÔNG hỗ trợ hoàn tiền.");
            }

            System.out.println();
        }
    }
}
