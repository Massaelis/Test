package com.prodius.lesson7hw.util;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Util {

    public int lengthList() {
        final Scanner scan = new Scanner(System.in);

        int number = 0;
        do {
            System.out.println("Введите число: ");
            if (scan.hasNextInt()) {
                number = scan.nextInt();
            } else {
                scan.next();
            }
        } while (number == 0);

        return number;
    }

    public List<Integer> createList(final int length) {
        final List<Integer> list = new ArrayList<>();
        final Random random = new Random();

        for (int i = 0; i < length; i++) {
            int number = random.nextInt(-50, 50);
            list.add(number);
        }
        System.out.println(list);
        return list;
    }

    public void testList(final List<Integer> list) {
        int sum = 0;

        try {
            for (int element : list) {
                if (element >= 0) {
                    sum += element;
                } else {
                    try {
                        throw new IllegalArgumentException("Invalid number " + element);
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println(e.getStackTrace());
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    }
                }
            }
        } finally {
            System.out.println(sum);
        }
    }
}
