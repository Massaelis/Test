package com.prodius.lesson11hw.treeSet;

import lombok.ToString;

public class TreeSet {
    @ToString
    static class Person implements Comparable<Person> {
        public final int age;

        public final String name;

        Person(final int age) {
            this.age = age;
            this.name = "Name" + Math.random();
        }

        @Override
        public int compareTo(final Person o) {
            int compare = Integer.compare(this.age, o.age);
            if (compare == 0) {
                compare = this.name.compareTo(o.name);
            }
            return compare;
        }
    }
}
