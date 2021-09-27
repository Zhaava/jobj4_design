package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int count;
    private int size;

    public T poll() {
        if (count == 0) {
            while (count != size) {
                out.push(in.pop());
                count++;
            }
            size = 0;
        }
        count--;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        size++;
    }
}
