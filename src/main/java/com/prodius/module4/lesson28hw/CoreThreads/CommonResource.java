package com.prodius.module4.lesson28hw.CoreThreads;

import java.util.ArrayList;
import java.util.List;

public class CommonResource {
    private final List<Integer> list = new ArrayList<>();

    CommonResource() {
        list.add(0);
    }

    public synchronized void incrise() {
        int integer = list.get(0);
        integer += 1;
        list.set(0, integer);
    }

    Integer get() {
        return list.get(0);
    }
}
