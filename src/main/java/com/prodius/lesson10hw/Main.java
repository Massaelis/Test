package com.prodius.lesson10hw;

import com.prodius.lesson10hw.shapes.Circle;
import com.prodius.lesson10hw.shapes.Rectangle;
import com.prodius.lesson10hw.shapes.Triangle;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Triangle triangle = new Triangle();

        double triangleOne = triangle.triangleArea(1.2, 2.1, 2.2);
        double triangleTwo = triangle.triangleArea(2.2, 2.2, 2.2);
        double triangleThree = triangle.triangleArea(3.2, 2.3, 2.2);

        List<? super Number> triangleList = new ArrayList<>();

        triangleList.add(triangleOne);
        triangleList.add(triangleTwo);
        triangleList.add(triangleThree);
        System.out.println();
        totalArea((List<? extends Number>) triangleList);

        System.out.println("~".repeat(20));

        Rectangle rectangle = new Rectangle();

        List<? super Number> rectangleList = new ArrayList<>();

        rectangleList.add(rectangle.rectangleArea(2.3, 3.3));
        rectangleList.add(rectangle.rectangleArea(4, 3.4));
        rectangleList.add(rectangle.rectangleArea(5, 3.5));
        System.out.println();
        totalArea((List<? extends Number>) rectangleList);

        System.out.println("~".repeat(20));

        Circle circle = new Circle();

        List<? super Number> circleList = new ArrayList<>();

        circleList.add(circle.circleArea(3.4));
        circleList.add(circle.circleArea(3));
        circleList.add(circle.circleArea(2.1));
        System.out.println();
        totalArea((List<? extends Number>) circleList);
    }

    public static void totalArea(final List<? extends Number> list) {
        double sum = 0;
        for (Number e : list) {
            sum += e.doubleValue();
        }
        System.out.println("Total area: " + sum);
    }
}
