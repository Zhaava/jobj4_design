package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int countEmpty = 0;
        for (int[] el : data) {
            if (el.length == 0) {
                countEmpty++;
            }
        }
        return row < data.length && countEmpty < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (column >= data[row].length) {
            row++;
            column = 0;
        }
        return data[row][column++];
    }
}
