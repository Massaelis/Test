package com.prodius.lesson12hw;

import java.util.ArrayList;
import java.util.Optional;

public class Service {
    public Optional<ArrayList> checkPersonAgeValue(final ArrayList<Integer> values) {
        try {
            for (int i = 0; i < values.size(); i++) {
                if (values.get(i) == null) {
                    throw new NullPointerException();
                }
                if (values.get(i) < 0) {
                    throw new IllegalArgumentException();
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Negative age is not allowed");
        } catch (NullPointerException e) {
            System.out.println("List contains null");
        } finally {
            System.out.println(values);
        }
        return Optional.ofNullable(values);
    }

//    public static Optional<Map> personAge(Map<Integer, Integer> map) {
//        for (Map.Entry entry : map.entrySet()) {
//            if (entry == null) {
//                System.out.println("List contains null");
//                return Optional.empty();
//            }
//            System.out.println(entry);
//        }
//        return Optional.empty();
//    }

}
