package IOC_BE.SS17.BaiTap03_SS17;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import IOC_BE.SS17.ConnectionDB;

public class BookManagement {
    public void addBook(Book book) {
        try(Connection conn = ConnectionDB.getConnection();
            CallableStatement stmt = conn.prepareCall("{call ex3.add_book(?, ?, ?)}")) {
            CallableStatement books = conn.prepareCall("{call ex3.list_books()}");
            ResultSet rs = books.executeQuery();

            while (rs.next()) {
                if (rs.getString("title").equalsIgnoreCase(book.getTitle()) && rs.getString("author").equalsIgnoreCase(book.getAuthor())) {
                    System.out.println("Sách " + book.getTitle() + " của tác giả " + book.getAuthor() + " đã tồn tại trong cơ sở dữ liệu.");
                    return;
                }
            }
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setDouble(3, book.getPrice());
            stmt.execute();

        } catch (Exception e) {
            System.out.println("Lỗi khi thêm sách vào cơ sở dữ liệu: " + e.getMessage());
        }
    }

    public void listBooks() {
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall("{call ex3.list_books()}")) {
            ResultSet rs = stmt.executeQuery();
            System.out.println("+-----+--------------------------------------------------+------------------------------+--------------------+");
            System.out.println("|ID   |Title                                             |Author                        |Price               |");
            System.out.println("+-----+--------------------------------------------------+------------------------------+--------------------+");
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getDouble("price"));
                System.out.println(book);
            }
            System.out.println("+-----+--------------------------------------------------+------------------------------+--------------------+");
        } catch (Exception e) {
            System.out.println("Lỗi khi liệt kê sách: " + e.getMessage());
        }
    }

    public void getBooksByAuthor(String author) {
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall("{call ex3.get_books_by_author(?)}")) {
            stmt.setString(1, author);
            ResultSet rs = stmt.executeQuery();
            System.out.println("+-----+--------------------------------------------------+------------------------------+--------------------+");
            System.out.println("|ID   |Title                                             |Author                        |Price               |");
            System.out.println("+-----+--------------------------------------------------+------------------------------+--------------------+");
            boolean found = false;
            while (rs.next()) {
                found = true;
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getDouble("price"));
                System.out.println(book);
            }
            System.out.println("+-----+--------------------------------------------------+------------------------------+--------------------+");
            if (!found) {
                System.out.println("Không tìm thấy sách nào của tác giả: " + author);
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi tìm kiếm sách theo tác giả: " + e.getMessage());
        }
    }

    public void deleteBookById(int id) {
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall("{call ex3.delete_book_by_id(?)}")) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Lỗi khi xóa sách: " + e.getMessage());
        }
    }

    public void updateBook(int id, Book updatedBook) {
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement stmt = conn.prepareCall("{call ex3.update_book(?, ?, ?, ?, ?)}")) {
            stmt.setInt(1, id);
            stmt.setString(2, updatedBook.getTitle());
            stmt.setString(3, updatedBook.getAuthor());
            stmt.setInt(4, updatedBook.getPublishYear());
            stmt.setDouble(5, updatedBook.getPrice());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật sách: " + e.getMessage());
        }
    }
}