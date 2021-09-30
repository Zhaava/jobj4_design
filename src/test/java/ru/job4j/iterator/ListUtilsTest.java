package ru.job4j.iterator;

import org.junit.Test;
import ru.job4j.generic.Predator;

import static org.hamcrest.Matchers.is;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);

        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        Predicate<Integer> pred = f -> f % 2 != 0;
        ListUtils.removeIf(input, pred);
        assertThat(input, is(Arrays.asList(0, 2, 4, 6)));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        Predicate<Integer> pred = f -> f == 3;
        ListUtils.replaceIf(input, pred, 7);
        assertThat(input, is(Arrays.asList(0, 1, 2, 7, 4, 5, 6)));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        List<Integer> removeElements = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.removeAll(input, removeElements);
        assertThat(input, is(Arrays.asList(3, 4, 5, 6)));
    }

}
