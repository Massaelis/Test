package com.prodius.module2.lesson14hw;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final List<Order> orderList = prepareData();


//      a
        final List<Order> orders = orderList.stream()
                .filter(
                        order -> order.getProduct().stream()
                                .mapToDouble(product -> product.getPrice() * product.getQuantity())
                                .sum() > 2000
                ).filter(
                        order -> {
                            int sum = 0;
                            for (Product product : order.getProduct()) {
                                sum += product.getPrice() * product.getQuantity();
                            }
                            return sum > 2000;
                        }
                ).filter(order -> sumOfPrices2(order) > 2000)
                .collect(Collectors.toList());
        System.out.println(orders);

//      b & i
        final List<Order> sorted = orderList.stream()
                .sorted(Comparator.comparingInt(Order::getOrderId).reversed())
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println(sorted);

        // c
        final List<String> collect = orderList.stream()
                .flatMap(order -> order.getProduct().stream())
                .map(Product::getName)
                .collect(Collectors.toList());
        System.out.println(collect);

//      d
        final List<Order> limit = orderList.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(limit);

        // e
        final Map<Integer, Double> doubleMap = orderList.stream()
                .collect(Collectors.toMap(
                        Order::getOrderId,
                        Main::sumOfPrices2
                ));
        System.out.println(doubleMap);

//      f
        orderList.stream()
                .flatMap(order -> order.getProduct().stream())
                .mapToDouble(Product::getPrice)
                .max()
                .ifPresent(System.out::println);


//      g
        final boolean anyMatch = orderList.stream()
                .flatMap(order -> order.getProduct().stream())
                .anyMatch(product -> "iPhone XR".equals(product.getName()));
        System.out.println(anyMatch);

    }

    private static List<Order> prepareData() {
        final Product telephone1 = new Product("iPhone XR", 500, 8);
        final Product telephone2 = new Product("iPhone 7", 400, 4);
        final Product telephone3 = new Product("iPhone 13", 900, 1);
        final Order order1 = new Order(1, List.of(telephone1, telephone2, telephone3));

        final Product television1 = new Product("Samsung Q47", 600, 1);
        final Product television2 = new Product("Samsung Q50", 700, 3);
        final Product television3 = new Product("Samsung Q60", 800, 2);
        final Order order2 = new Order(2, List.of(television1, television2, television3));

        final Product telephone4 = new Product("iPhone XR", 500, 3);
        final Product telephone5 = new Product("iPhone 7", 400, 8);
        final Order order3 = new Order(4, List.of(telephone4, telephone5));

        final Product television4 = new Product("Samsung Q47", 600, 2);
        final Product television5 = new Product("Samsung Q50", 700, 2);
        final Order order4 = new Order(3, List.of(television4, television5));

        return List.of(order1, order2, order3, order4);
    }


    public static double sumOfPrices2(final Order order) {
        double sum = 0.0;
        for (Product product : order.getProduct()) {
            sum += product.getPrice() * product.getQuantity();
        }
        return sum;
    }
}