package IOC_BE.SS17.BaiTap04_SS17;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

import  IOC_BE.SS17.ConnectionDB;

public class ProductManagement {
    public void addProduct(Scanner scanner) {
        Product product = new Product();
        while (true) {
            System.out.print("Enter product name: ");
            String name = scanner.nextLine();
            if (name.trim().isEmpty()) {
                System.out.println("Product name cannot be empty. Please try again.");
                continue;
            }
            product.setName(name);
            break;
        }

        while (true) {
            System.out.print("Enter product price: ");
            String priceInput = scanner.nextLine();
            try {
                double price = Double.parseDouble(priceInput);
                if (price < 0) {
                    System.out.println("Price cannot be negative. Please try again.");
                    continue;
                }
                product.setPrice(price);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid price format. Please enter a valid number.");
            }
        }

        try(Connection conn = ConnectionDB.getConnection();
            CallableStatement stmt = conn.prepareCall("{call ex4.add_product(?, ?)}")) {
            CallableStatement products = conn.prepareCall("{call ex4.list_products()}");
            java.sql.ResultSet rs = products.executeQuery();
            while (rs.next()) {
                if (rs.getString("name").equalsIgnoreCase(product.getName())) {
                    System.out.println("Product " + product.getName() + " already exists in the database.");
                    return;
                }
            }
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Error adding product to database: " + e.getMessage());
        }
    }


}