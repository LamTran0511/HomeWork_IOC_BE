package IOC_BE.SS13.BaiTap02_SS13;

import java.util.ArrayList;
import java.util.List;

public class AttendanceManager implements Manage<Student> {
    private final List<Student> students = new ArrayList<>();

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public void update(int id, Student student) {
        students.set(getIndex(id), student);
    }

    @Override
    public void delete(int id) {
        students.remove(getIndex(id));
    }

    @Override
    public List<Student> display() {
        return students;
    }

    private int getIndex(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
