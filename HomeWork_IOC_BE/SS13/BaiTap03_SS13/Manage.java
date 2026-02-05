package IOC_BE.SS13.BaiTap03_SS13;

import java.util.List;

public interface Manage<T> {
    void add(T t);
    void update(int id, T t);
    void delete(int id);
    List<T> display();
}