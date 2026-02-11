package IOC_BE.SS15.BaiTap01_SS15;

import java.util.ArrayList;
import java.util.List;

public class MovieManager<T> {
    private final ArrayList<T> movies = new ArrayList<>();

    public void add(T movie) {
        movies.add(movie);
    }

    public List<T> getAll() {
        return new ArrayList<>(movies);
    }

    // Vì bài này thao tác theo id/title/rating nên ta xử lý khi T là Movie
    public boolean deleteById(int id) {
        for (int i = 0; i < movies.size(); i++) {
            Movie m = (Movie) movies.get(i);
            if (m.getId() == id) {
                movies.remove(i);
                return true;
            }
        }
        return false;
    }

    public Movie findById(int id) {
        for (T t : movies) {
            Movie m = (Movie) t;
            if (m.getId() == id) return m;
        }
        return null;
    }

    public List<Movie> searchByTitle(String keyword) {
        List<Movie> result = new ArrayList<>();
        String key = keyword.toLowerCase();

        for (T t : movies) {
            Movie m = (Movie) t;
            if (m.getTitle().toLowerCase().contains(key)) {
                result.add(m);
            }
        }
        return result;
    }

    public List<Movie> filterRatingGreaterThan(double min) {
        List<Movie> result = new ArrayList<>();
        for (T t : movies) {
            Movie m = (Movie) t;
            if (m.getRating() > min) {
                result.add(m);
            }
        }
        return result;
    }
}
