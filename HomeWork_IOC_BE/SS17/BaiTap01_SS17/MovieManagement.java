package IOC_BE.SS17.BaiTap01_SS17;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

import IOC_BE.SS17.ConnectionDB;

public class MovieManagement {

    public void addMovie(Scanner scanner) {
        Movie movie = new Movie();
        movie.inputData(scanner);
        try {
            Connection conn = ConnectionDB.getConnection();
            CallableStatement stmt = conn.prepareCall("{call add_movie(?, ?, ?)}");
            stmt.setString(1, movie.getTitle());
            stmt.setString(2, movie.getDirector());
            stmt.setInt(3, movie.getRelease_year());
            stmt.execute();
            conn.close();
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm phim vào cơ sở dữ liệu: " + e.getMessage());
        }
    }

    public void displayMovies() {
        try {
            Connection conn = ConnectionDB.getConnection();
            CallableStatement stmt = conn.prepareCall("{call list_movies()}");
            java.sql.ResultSet rs = stmt.executeQuery();
            System.out.println("+-----+--------------------------------------------------+------------------------------+-----+");
            System.out.println("|ID   |Title                                             |Director                      |Year |");
            System.out.println("+-----+--------------------------------------------------+------------------------------+-----+");
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDirector(rs.getString("director"));
                movie.setRelease_year(rs.getInt("release_year"));
                System.out.println(movie);
            }
            System.out.println("+-----+--------------------------------------------------+------------------------------+-----+");
            conn.close();
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị danh sách phim: " + e.getMessage());
        }
    }

    public void updateMovie(Scanner scanner) {
        int id = 0;
        while (true) {
            try {
                System.out.print("Nhập ID của phim cần cập nhật: ");
                id = Integer.parseInt(scanner.nextLine());
                if (id <= 0) {
                    throw new IllegalArgumentException("ID phải là số nguyên dương.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi nhập liệu, vui lòng nhập một số nguyên hợp lệ.");
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi nhập liệu, " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Lỗi không xác định, vui lòng thử lại.");
            }
        }

        Movie movie = new Movie();
        movie.inputData(scanner);

        try {
            Connection conn = ConnectionDB.getConnection();
            CallableStatement stmt = conn.prepareCall("{call update_movie(?, ?, ?, ?)}");
            stmt.setInt(1, id);
            stmt.setString(2, movie.getTitle());
            stmt.setString(3, movie.getDirector());
            stmt.setInt(4, movie.getRelease_year());
            stmt.execute();
            conn.close();
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật phim: " + e.getMessage());
        }

    }

    public void deleteMovie(Scanner scanner) {
        int id = 0;
        while (true) {
            try {
                System.out.print("Nhập ID của phim cần xóa: ");
                id = Integer.parseInt(scanner.nextLine());
                if (id <= 0) {
                    throw new IllegalArgumentException("ID phải là số nguyên dương.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi nhập liệu, vui lòng nhập một số nguyên hợp lệ.");
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi nhập liệu, " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Lỗi không xác định, vui lòng thử lại.");
            }
        }

        try {
            Connection conn = ConnectionDB.getConnection();
            CallableStatement stmt = conn.prepareCall("{call delete_movie(?)}");
            stmt.setInt(1, id);
            stmt.execute();
            conn.close();
        } catch (Exception e) {
            System.out.println("Lỗi khi xóa phim: " + e.getMessage());
        }

    }
}