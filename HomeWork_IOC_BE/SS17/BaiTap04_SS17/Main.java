package IOC_BE.SS17.BaiTap04_SS17;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerManagement customerManagement = new CustomerManagement();

        while (true) {
            System.out.println("1. Update Customer");
            System.out.println("2. Create Order");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    customerManagement.updateCustomer(scanner);
                    break;
                case "2":
                    OrderManagement orderManagement = new OrderManagement();
                    orderManagement.createOrder(scanner);
                    break;
                case "3":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}