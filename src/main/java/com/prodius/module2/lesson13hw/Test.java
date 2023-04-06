package com.prodius.module2.lesson13hw;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

enum SortType {
    ASCENDING, DESCENDING
}

public class Test {

    private static final Random RANDOM = new Random();

    public void sortList(final List<String> list) {
        final SortType[] sortTypes = SortType.values();
        final int number = RANDOM.nextInt(sortTypes.length);
        final SortType sortType = sortTypes[number];
        if (sortType == SortType.ASCENDING) {
            compare(list, this::compare);
        } else if (sortType == SortType.DESCENDING) {
            compare(list, this::compareNegative);
        } else {
            throw new IllegalArgumentException("Invalid sort type: " + sortType);
        }
    }


    private void compare(final List<String> list, final Comparator<String> comparator) {
        list.sort(comparator);
    }

    private int compare(final String first, final String second) {
        return first.compareTo(second);
    }

    private int compareNegative(final String first, final String second) {
        return second.compareTo(first);
    }

}
