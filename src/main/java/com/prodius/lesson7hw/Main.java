package com.prodius.lesson7hw;

import com.prodius.lesson7hw.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Util util = new Util();
        int length = util.lengthList();
        List<Integer> list = util.createList(length);
        util.testList(list);
    }
}