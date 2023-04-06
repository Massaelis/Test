package com.prodius.module2.lesson6hw.repository;

import com.prodius.module2.lesson6hw.product.Product;
import com.prodius.module2.lesson6hw.product.ProductType;

public class Repository {
    private static Product[] products = new Product[20];

    private static int index = 0;

    public void save(final Product obj) {
        if (index == products.length) {
            increaseArray();
        }
        products[index++] = obj;
    }

    private void increaseArray() {
        final Product[] newObj = new Product[products.length * 2];
        System.arraycopy(products, 0, newObj, 0, products.length);
        products = newObj;
    }

    public Product[] getAllProducts() {
        if (index == products.length - 1) {
            return products;
        } else {
            final Product[] products1 = new Product[index];
            System.arraycopy(products, 0, products1, 0, products1.length);
            return products1;
        }
    }

    public Product[] getAllProducts(final ProductType type) {
        int count = 0;
        for (Product product : products) {
            if (product == null) {
                break;
            }
            if (product.getType() == type) {
                count++;
            }
        }

        if (count == products.length - 1) {
            return products;
        } else {
            final Product[] products1 = new Product[count];
            for (int i = 0, y = 0; i < products.length; i++) {
                if (products[i] == null) {
                    break;
                }
                if (products[i].getType() == type) {
                    products1[y++] = products[i];
                }
            }
            return products1;
        }
    }
}