package com.prodius.lesson12;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://vertex-academy.com/tutorials/ru/java-8-novye-metody-map/
public class Main {
    public static void main(String[] args) {
        final Map<Cat, Integer> map = new HashMap<>();

        map.put(new Cat(1), 1);
        final Cat cat = new Cat(2);
        map.put(cat, 2);

        System.out.println(map);

        final Integer key1 = map.get(new Cat(1));
        System.out.println("New key1: " + key1);

        System.out.println(cat.hashCode());
        final Integer key21 = map.get(cat);
        System.out.println("Exist key2: " + key21);

        cat.setAge(3);
        System.out.println(cat.hashCode());
        final Integer key22 = map.get(cat);
        System.out.println("Exist key2: " + key22);

        System.out.println(map);


        final Map<String, Integer> map2 = new HashMap<>();
        map2.put("1", 1);
        map2.put("2", 12);

        final Integer key31 = map2.get("1");
        System.out.println("key31: " + key31);

        System.out.println(map2);

        map2.put("1", 111);
        System.out.println(map2);

        Map<String, List<Map<String, Set<Integer>>>> hardMap = new HashMap<>();
        final Set<Integer> innerSet = new HashSet<>();
        final Map<String, Set<Integer>> innerMap = new HashMap<>();
        final List<Map<String, Set<Integer>>> innerList = new ArrayList<>();

        hardMap.put("outer", innerList);
        innerList.add(innerMap);
        innerMap.put("innerKey", innerSet);
        innerSet.add(1);
        System.out.println(hardMap);
    }
}

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
class Cat {
    private int age;
}
