package ru.job4j.generic;

import java.util.HashMap;
import java.util.Map;

public class MemStore<T extends Base> implements Store<T> {
    private final Map<String, T> mem = new HashMap<>();

    @Override
    public void add(T model) {
        mem.put(model.getId(), model);
    }

    @Override
    public T replace(String id, T model) {
        return mem.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return mem.remove(id, mem.get(id));
    }

    @Override
    public T findById(String id) {
        return mem.get(id);
    }
}
