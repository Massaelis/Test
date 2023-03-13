package com.prodius.lesson6hw.service;

import com.prodius.lesson6hw.product.MeasurableProduct;
import com.prodius.lesson6hw.product.Product;
import com.prodius.lesson6hw.product.ProductType;
import com.prodius.lesson6hw.product.Refrigerator;
import com.prodius.lesson6hw.product.Tablet;
import com.prodius.lesson6hw.product.Telephone;
import com.prodius.lesson6hw.product.Television;
import com.prodius.lesson6hw.repository.Repository;

import java.util.Objects;

public class Service {
    private final Repository repository;

    public Service(final Repository repository) {
        this.repository = repository;
    }

    public Television createTelevision(
            final String name, final int price, final int quantity, final double diagonal, final String colorRendering
    ) {
        Television television = new Television(name, price, quantity, diagonal, colorRendering);
        repository.save(television);
        return television;
    }

    public Refrigerator createRefrigerator(
            final String name, final int price, final int power
    ) {
        Refrigerator refrigerator = new Refrigerator(name, price, power);
        repository.save(refrigerator);
        return refrigerator;
    }

    public Telephone createTelephone(
            final String name, final int price, final int quantity, final double diagonal, final int generation
    ) {
        Telephone telephone = new Telephone(name, price, quantity, diagonal, generation);
        repository.save(telephone);
        return telephone;
    }

    public Tablet createTablet(
            final String name, final int price, final int quantity, final int rating
    ) {
        Tablet tablet = new Tablet(name, price, quantity, rating);
        repository.save(tablet);
        return tablet;
    }

    public void sumAllProduct() {
        final Product[] allProducts = repository.getAllProducts();
        int sum = 0;
        for (Product product : allProducts) {
            if (product instanceof MeasurableProduct measurableProduct) {
                sum += measurableProduct.getCount() * measurableProduct.getPrice();
            } else {
                sum += product.getPrice();
            }
        }

        System.out.println("Sum all products ~ " + sum);
    }

    public void countByType(final ProductType type) {
        System.out.println(repository.getAllProducts(type).length);
    }

    public boolean isTheSame(final Product first, final Product second) {
        System.out.println("Compare two products:");
        System.out.println(first);
        System.out.println(second);
        final boolean sameType = isTheSameType(first, second);
        if (!sameType) {
            return false;
        }

        final boolean sameHash = isTheSameHash(first, second);
        if (sameHash) {
            return isTheSameValue(first, second);
        }
        return false;
    }

    private boolean isTheSameValue(final Product first, final Product second) {
        final boolean sameName = Objects.equals(first.getName(), second.getName());
        final boolean samePrice = Objects.equals(first.getPrice(), second.getPrice());
        return sameName && samePrice;
    }

    private boolean isTheSameHash(final Product first, final Product second) {
        final int firstHash = Objects.hash(first.getName(), first.getPrice());
        final int secondHash = Objects.hash(second.getName(), second.getPrice());
        return firstHash == secondHash;
    }

    private boolean isTheSameType(final Product first, final Product second) {
        if (first == null || second == null) {
            return false;
        }
        return first.getType() == second.getType();
    }
}
