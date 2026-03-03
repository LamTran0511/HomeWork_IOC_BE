package IOC_BE.SS17.BaiTap04_SS17;


import java.util.Scanner;

public class OrderManagement {
    public void createOrder(Scanner scanner) {
        Order order = new Order();
        while (true) {
            System.out.print("Enter customer ID: ");
            String customerIdInput = scanner.nextLine();
            try {
                int customerId = Integer.parseInt(customerIdInput);
                order.setCustomerId(customerId);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer for customer ID.");
            }
        }

        while (true) {
            System.out.println("Enter product ID (Enter 'Exit' to finish): ");
            String productIdInput = scanner.nextLine();
            if (productIdInput.equalsIgnoreCase("Exit")) {
                break;
            }

            try {
                int productId = Integer.parseInt(productIdInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer for product ID.");
            }

            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(Integer.parseInt(productIdInput));

            while (true) {
                System.out.println("Enter quantity: ");
                String quantityInput = scanner.nextLine();
                try {
                    int quantity = Integer.parseInt(quantityInput);
                    if (quantity <= 0) {
                        System.out.println("Quantity must be greater than zero. Please try again.");
                        continue;
                    }
                    orderItem.setQuantity(quantity);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid integer for quantity.");
                }
            }
        }

    }
}