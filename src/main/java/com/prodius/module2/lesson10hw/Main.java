package com.prodius.module2.lesson10hw;

import com.prodius.module2.lesson10hw.shapes.Circle;
import com.prodius.module2.lesson10hw.shapes.Figure;
import com.prodius.module2.lesson10hw.shapes.Rectangle;
import com.prodius.module2.lesson10hw.shapes.Triangle;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Figure> list = new ArrayList<>();
        createCircle(list);
        createRectangle(list);
        createTriangle(list);
        totalArea(list);
    }

    private static void createCircle(final List<? super Figure> figures) {
        figures.add(new Circle<>(5));
        figures.add(new Circle<>(10.0));
        figures.add(new Circle<>(8));
    }

    private static void createTriangle(final List<? super Figure> figures) {
        figures.add(new Triangle<>(5, 6, 7));
        figures.add(new Triangle<>(1, 2, 3));
        figures.add(new Triangle<>(6, 7, 8));
    }

    private static void createRectangle(final List<? super Figure> figures) {
        figures.add(new Rectangle<>(5, 6));
        figures.add(new Rectangle<>(1, 2));
        figures.add(new Rectangle<>(6, 7));
    }

    public static void totalArea(final List<? extends Figure> list) {
        double sum = 0;
        for (Figure e : list) {
            sum += e.getArea();
        }
        System.out.println("Total area: " + sum);
    }
}
