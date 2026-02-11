package IOC_BE.SS15.BaiTap02_SS15;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SubjectManager<T> {
    private final ArrayList<T> subjects = new ArrayList<>();

    public void add(T subject) {
        subjects.add(subject);
    }

    public List<T> getAll() {
        return new ArrayList<>(subjects);
    }

    public void showAll() {
        if (subjects.isEmpty()) {
            System.out.println("(Danh sach mon hoc rong)");
            return;
        }
        subjects.forEach(System.out::println);
    }

    public boolean deleteByCode(String code) {
        return subjects.removeIf(s -> ((Subject) s).getCode().equalsIgnoreCase(code));
    }

    // Stream + Optional: tim theo name (contains, ignore case)
    public Optional<Subject> findFirstByName(String keyword) {
        String key = keyword.toLowerCase();
        return subjects.stream()
                .map(s -> (Subject) s)
                .filter(sub -> sub.getName().toLowerCase().contains(key))
                .findFirst();
    }

    // Stream: loc credits > 3
    public List<Subject> filterCreditsGreaterThan(int minCredits) {
        return subjects.stream()
                .map(s -> (Subject) s)
                .filter(sub -> sub.getCredits() > minCredits)
                .collect(Collectors.toList());
    }
}
