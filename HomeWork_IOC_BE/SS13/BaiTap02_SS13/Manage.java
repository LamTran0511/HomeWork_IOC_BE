package IOC_BE.SS13.BaiTap02_SS13;

import java.util.List;

public interface Manage<T> {
    void add(T t);
    void update(int index, T t);
    void delete(int index);
    List<T> display();
}