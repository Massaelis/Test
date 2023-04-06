package com.prodius.module2.lesson10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        extendsExample();
        wildcardExtendsExample();
    }

    private static void wildcardExtendsExample() {
        List<Integer> listInt0 = new ArrayList<>();
//        List<Number> numberList = listInt0; ERROR
        Collection<Integer> numberCollection = listInt0;

        List<Integer> listInt = new ArrayList<>();
        List<? extends Number> numberList = listInt;
//        numberList.add(5); ERROR
        numberList.add(null);
        final Number number = numberList.get(0);

        List<?> objectList = listInt;
//        objectList.add(5); ERROR
        objectList.add(null);
        final Object o = objectList.get(0);

        List<Integer> intNumbers = List.of(1, 2, 3);
        List<Double> doublesNumbers = List.of(1.0, 2.0, 3.0);
        List<Number> numNumbers = List.of(1.0, 2.0, 3.0);

        ArrayList<Integer> arrayListInt = new ArrayList<>();
        LinkedList<Integer> linkedListInt = new LinkedList<>();


        sumList(intNumbers);
        sumList(doublesNumbers);
        sumList(numNumbers);
        sumList(arrayListInt);
        sumList(linkedListInt);

        sumList2(intNumbers);
        sumList2(doublesNumbers);
        sumList2(numNumbers);
        sumList2(arrayListInt);
        sumList2(linkedListInt);

        final ProducerBytes producerBytes = new ProducerBytes();
        final ProducerInt producerInt = new ProducerInt();
        final ProducerDouble producerDouble = new ProducerDouble();
        List<? extends Number> list;

        final int anInt = new Random().nextInt(10);
        if (anInt < 3) {
            list = producerDouble.produce();
        } else if (anInt < 6) {
            list = producerInt.produce();
        } else {
            list = producerBytes.produce();
        }
//        list.add(5); ERROR

        list.forEach(n -> System.out.println(n));
    }

    private static void test(final List<? super Integer> list) {
        final Integer a = 1;
        list.add(a);

        final Number b = 2;
//        list.add(b);
    }


    private static void sumList(final List<? extends Number> list) {
        double sum = 0;
        for (Number e : list) {
            sum += e.doubleValue();
        }
        System.out.println(sum);
    }

    private static <E extends Number> void sumList2(final List<E> list) {
        double sum = 0;
        for (E e : list) {
            sum += e.doubleValue();
        }
        System.out.println(sum);
    }

    private static void extendsExample() {
        sum(1, 1);
        sum(10.5, 45);
        sum(45, 10.5);
    }

    private static <E extends Number> void sum(final E a, final E b) {
        final double rc = a.doubleValue() + b.doubleValue();
        System.out.println(rc);
    }
}

class ProducerInt {
    List<Integer> produce() {
        return Collections.emptyList();
    }
}

class ProducerDouble {
    List<Double> produce() {
        return Collections.emptyList();
    }
}

class ProducerBytes {
    List<Byte> produce() {
        return Collections.emptyList();
    }
}