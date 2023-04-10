package com.prodius.module2.lesson14hw;

import lombok.Getter;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        final Product telephone1 = new Product("iPhone XR", 500, 2);
        final Product telephone2 = new Product("iPhone 7", 400, 4);
        final Product telephone3 = new Product("iPhone 13", 900, 1);
        final Order order1 = new Order(1, List.of(telephone1, telephone2, telephone3));
        
        final Product television1 = new Product("Samsung Q47", 600, 1);
        final Product television2 = new Product("Samsung Q50", 700, 3);
        final Product television3 = new Product("Samsung Q60", 800, 2);
        final Order order2 = new Order(2, List.of(television1, television2, television3));

        final Product telephone4 = new Product("iPhone XR", 500, 3);
        final Product telephone5 = new Product("iPhone 7", 400, 3);
        final Order order3 = new Order(4, List.of(telephone4, telephone5));

        final Product television4 = new Product("Samsung Q47", 600, 2);
        final Product television5 = new Product("Samsung Q50", 700, 2);
        final Order order4 = new Order(3, List.of(television4, television5));


//      a
        final List<Product> orders = Stream.of(order1, order2)
//                .filter(p -> p.getProduct().get(0).getPrice() * p.getProduct().get(0).getQuantity() > 5000)
//                .filter(p -> p.getProduct().get(1).getPrice() * p.getProduct().get(1).getQuantity() > 5000)
                .flatMap(order -> order.getProduct().stream())
                .peek(p -> System.out.println(p.getPrice() * p.getQuantity()))
                .filter(product -> product.getPrice() * product.getQuantity() > 1000)
                .collect(Collectors.toList());
        System.out.println(orders);
//      test
        final double orders2 = Stream.of(order1, order2)
                .flatMap(order -> order.getProduct().stream())
                .mapToDouble((c) -> Double.parseDouble(String.valueOf(c.getPrice() * c.getQuantity()))).sum();
        System.out.println(orders2);

//      b & i
        final List<Order> sorted = new ArrayList<>(Arrays.asList(order1, order2, order3, order4))
                .stream()
                .sorted(Comparator
                        .comparingInt(Order::getOrderId)
                        .reversed()
                )
                .collect(Collectors.toList());
//        sorted.forEach(System.out::println);

//      d
        final List<Order> limit = new ArrayList<>(Arrays.asList(order1, order2, order3, order4))
                .stream()
                .limit(3)
                .collect(Collectors.toList());
//        limit.forEach(System.out::println);

//      f
        Stream.of(order1, order2)
                .flatMap(order -> order.getProduct().stream())
                .mapToDouble(Product::getPrice)
                .max()
                .ifPresent(System.out::println);


//      g
        final boolean anyMatch = Stream.of(order1, order2)
                .flatMap(order -> order.getProduct().stream())
                .anyMatch(television2::equals);
        System.out.println(anyMatch);

    }


//    public static double sumOfPrices2(List<Product> orders) {
//        double sum = 0.0;
//        for (Product products : orders) {
//            sum += products.getPrice();
//        }
//        return sum;
//    }
}

@ToString
@Getter
class Order {
    private final int orderId;
    private List<Product> product;

    Order(int orderId, List<Product> product) {
        this.orderId = orderId;
        this.product = product;
    }

    Order(int orderId) {
        this.orderId = orderId;
    }


}

@ToString
@Getter
class Product {
    private final String name;
    private final double price;
    private final int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
