package com.prodius.module2.lesson14hw;

import lombok.Value;

import java.util.List;

@Value
public class Order {
    int orderId;

    List<Product> product;
}