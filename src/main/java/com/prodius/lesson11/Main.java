package com.prodius.lesson11;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        iterator();
        list();
        set();
    }

    private static void set() {
        final Comparator<Cat> catComparator = new CatComparator();
        final Comparator<Cat> catNameComparator = new CatNameComparator();
        final Comparator<Cat> totalComparator = catComparator.thenComparing(catNameComparator);

        final Set<Cat> cats = new TreeSet<>(totalComparator);
        cats.add(new Cat(5));
        cats.add(new Cat(10));
        cats.add(new Cat(1));
        System.out.println(cats);

        final Set<Cat> cats2 = new TreeSet<>(Comparator.comparingInt(o -> o.age));
        cats2.add(new Cat(5));
        cats2.add(new Cat(10));
        cats2.add(new Cat(1));
        System.out.println(cats);

        cats2.stream()
                .sorted(new CatComparator())
                .sorted(Comparator.comparingInt(o -> o.age))
                .forEach(System.out::println);
    }

    private static void list() {
        final long listStart = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < 10_000_000; i++) {
            list.add(i);
        }
        final long listEnd = System.currentTimeMillis();
        System.out.println(listEnd - listStart);


        final long list2Start = System.currentTimeMillis();
        List<Integer> list2 = new ArrayList<>(10_000_000);
        for (int i = 0; i < 10_000_000; i++) {
            list2.add(i);
        }
        final long list2End = System.currentTimeMillis();
        System.out.println(list2End - list2Start);

        List<Integer> list3 = new ArrayList<>();
        list3.add(null);
        list3.add(null);
        System.out.println("Null size: " + list3.size());

        final long list4Start = System.currentTimeMillis();
        List<Integer> list4 = new LinkedList<>();
        for (int i = 0; i < 10_000_000; i++) {
            list4.add(i);
        }
        final long list4End = System.currentTimeMillis();
        System.out.println(list4End - list4Start);
    }

    private static void iterator() {
        final List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        /*java.util.ConcurrentModificationException
        for (Integer number : numbers) {
            if (number % 2 == 1) {
                numbers.remove(number);
            }
        }

        for (Integer number : numbers) {
            if (number % 2 == 1) {
                numbers.add(0);
            }
        }
        */

        System.out.println(numbers);
        final Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            final Integer number = iterator.next();
            if (number % 2 == 1) {
                iterator.remove();
            }
        }
        System.out.println(numbers);

        final List<Integer> numbers2 = new ArrayList<>();
        numbers2.add(1);
        numbers2.add(2);
        numbers2.add(3);
        numbers2.add(4);
        numbers2.add(5);
        System.out.println(numbers2);
        numbers2.removeIf(number -> number % 2 == 1);
        System.out.println(numbers2);
    }

    static class CatComparator implements Comparator<Cat> {
        @Override
        public int compare(final Cat o1, final Cat o2) {
            return Integer.compare(o1.age, o2.age);
        }
    }

    static class CatNameComparator implements Comparator<Cat> {
        @Override
        public int compare(final Cat o1, final Cat o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    @ToString
    static class Cat implements Comparable<Cat> {
        private final int age;

        private final String name;

        Cat(final int age) {
            this.age = age;
            this.name = "Name" + Math.random();
        }

        @Override
        public int compareTo(final Cat o) {
            int compare = Integer.compare(this.age, o.age);
            if (compare == 0) {
                compare = this.name.compareTo(o.name);
            }
            return compare;
        }
    }
}
