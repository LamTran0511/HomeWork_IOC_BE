package IOC_BE.SS17.BaiTap04_SS17;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

import IOC_BE.SS17.ConnectionDB;

public class CustomerManagement {
    public void updateCustomer(Scanner scanner) {
        int input = 0;
        while (true) {
            try {
                System.out.println("Enter customer ID to update: ");
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                continue;
            }
        }

        try(Connection conn = ConnectionDB.getConnection();
            CallableStatement stmt = conn.prepareCall("{call ex4.get_customer_by_id(?)}")) {
            stmt.setInt(1, input);
            java.sql.ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                System.out.println("Customer found: " + customer);

                System.out.println("Enter new name: ");
                String newName = scanner.nextLine();
                customer.setName(newName);

                System.out.println("Enter new email: ");
                String newEmail = scanner.nextLine();
                customer.setEmail(newEmail);

                CallableStatement updateStmt = conn.prepareCall("{call ex4.update_customer(?, ?, ?)}");
                updateStmt.setInt(1, customer.getId());
                updateStmt.setString(2, customer.getName());
                updateStmt.setString(3, customer.getEmail());
                updateStmt.execute();
                System.out.println("Customer updated successfully.");

            } else {
                System.out.println("Customer not found with ID: " + input);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}