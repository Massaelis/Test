package com.prodius.lesson12hw;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        final Map<Person, Integer> map = new HashMap<>();
        map.put(new Person(10), 1);
        map.put(new Person(20), 2);
        map.put(new Person(30), 3);
        System.out.println(map);
        //1
        System.out.println("PutIfAbsent");
        map.putIfAbsent(new Person(40), 4);
        System.out.println(map);
        //2
        System.out.println("ComputeIfAbsent");
        map.computeIfAbsent(new Person(50), key -> 5);
        System.out.println(map);
        //3
        System.out.println("Merge");
        map.merge(new Person(20), 1, (oldVal, newVal) -> oldVal + newVal);
        System.out.println(map);

//      personAge(map);

        map.put(null, null);
        map.put(new Person(60), -6);
        map.put(new Person(70), null);

        ArrayList<Integer> values = new ArrayList<>(map.values());
        service.checkPersonAgeValue(values);
    }
}