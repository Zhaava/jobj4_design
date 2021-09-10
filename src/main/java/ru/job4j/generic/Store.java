package ru.job4j.generic;

public interface Store<T extends Base> {
    void add(T model);

    T replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
