package SS8_G1;

public class CurrencyConverter {
    private static double rate = 25000;

    public static double getRate() {
        return rate;
    }

    public static void setRate(double rate) {
        CurrencyConverter.rate = rate;
    }

    public static double toUSD(double vnd) {
        return vnd * CurrencyConverter.rate;
    }
}