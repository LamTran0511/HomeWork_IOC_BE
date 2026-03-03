package IOC_BE.SS17.BaiTap01_SS17;


import java.util.Scanner;

public class Movie {
    private int id;
    private String title;
    private String director;
    private int release_year;

    public Movie() {
    }

    public Movie(String title, String director, int release_year) {
        this.title = title;
        this.director = director;
        this.release_year = release_year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("|%-5d|%-50s|%-30s|%-5d|", this.id, this.title, this.director, this.release_year));
        String trString = sb.toString();
        return trString;
    }

    public void inputData(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Nhập tên phim: ");
                String title = scanner.nextLine();
                if (title.trim().isEmpty()) {
                    throw new IllegalArgumentException("Tên phim không được để trống.");
                }
                this.title = title;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi nhập liệu, vui lòng thử lại.");
                scanner.nextLine(); // clear the invalid input
            }
        }

        while (true) {
            try {
                System.out.print("Nhập tên đạo diễn: ");
                String director = scanner.nextLine();
                if (director.trim().isEmpty()) {
                    throw new IllegalArgumentException("Tên đạo diễn không được để trống.");
                }
                this.director = director;
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi nhập liệu, vui lòng thử lại.");
                scanner.nextLine(); // clear the invalid input
            }
        }

        while (true) {
            try {
                System.out.print("Nhập năm phát hành: ");
                int year = Integer.parseInt(scanner.nextLine());
                if (year < 1000 || year > 9999) {
                    throw new NumberFormatException("Năm phát hành không hợp lệ.");
                }
                this.release_year = year;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi nhập liệu, vui lòng thử lại.");
            }
        }
    }
}