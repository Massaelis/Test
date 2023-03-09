package com.prodius.lesson6hw.service;

import com.prodius.lesson6hw.product.Refrigerator;
import com.prodius.lesson6hw.product.Tablet;
import com.prodius.lesson6hw.product.Telephone;
import com.prodius.lesson6hw.product.Television;
import com.prodius.lesson6hw.repository.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Service {
    Repository repository = new Repository();

    public Television createTelevision(Television television) {
        television = new Television(television.getName(), television.getPrice(), television.getQuantity(), television.getDiagonal(), television.getColorRendering());
        repository.save(television);
        television.display();
        return television;
    }

    public Refrigerator createRefrigerator(Refrigerator refrigerator) {
        refrigerator = new Refrigerator(refrigerator.getName(), refrigerator.getPrice(), refrigerator.getPower());
        refrigerator.display();
        return refrigerator;
    }

    public Telephone createTelephone(Telephone telephone) {
        telephone = new Telephone(telephone.getName(), telephone.getPrice(), telephone.getQuantity(), telephone.getDiagonal(), telephone.getGeneration());
        repository.save(telephone);
        telephone.display();
        return telephone;
    }

    public Tablet createTablet(Tablet tablet) {
        tablet = new Tablet(tablet.getName(), tablet.getPrice(), tablet.getQuantity(), tablet.getRating());
        tablet.display();
        return tablet;
    }

    public void sumAllProduct(Television television, Refrigerator refrigerator, Telephone telephone, Tablet tablet) {

        Integer[] integers = {television.getPrice() * television.getQuantity(),
                refrigerator.getPrice(),
                telephone.getPrice() * telephone.getQuantity(),
                tablet.getPrice() * tablet.getQuantity()};

        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(integers));
        System.out.println(intList);

        Integer sum = intList.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum all products ~ " + sum);
    }


    public void test(Television television, Refrigerator refrigerator, Telephone telephone, Tablet tablet) {
        television = new Television(television.getName(), television.getPrice(), television.getQuantity(), television.getDiagonal(), television.getColorRendering());
        refrigerator = new Refrigerator(refrigerator.getName(), refrigerator.getPrice(), refrigerator.getPower());

        Objects.equals(television.getName(), refrigerator.getName());
        System.out.println(Objects.equals(television, refrigerator));

    }

}
