package IOC_BE.SS13.BaiTap03_SS13;


import java.util.Scanner;

public class Invoice implements IBaseInvoice {
    private int idInvoice;
    private double amount;

    public Invoice() {
    }

    public Invoice(int idInvoice, double amount) {
        this.idInvoice = idInvoice;
        this.amount = amount;
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public void inputInvoice(Scanner sc) {

    }

    @Override
    public void displayData() {
        System.out.printf("ID: %s | Amount: %.2f\n", this.idInvoice, this.amount);
    }
}