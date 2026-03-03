package IOC_BE.SS18.BaiLuyenTap01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/ProductManagement";
    private static final String USER = "postgres";
    private static final String PASS = "526412"; // sửa mật khẩu của bạn

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}