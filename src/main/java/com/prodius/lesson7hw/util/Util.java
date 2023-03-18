package com.prodius.lesson7hw.util;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Util {
    private static final Scanner scan = new Scanner(System.in);
    List<Integer> list = new ArrayList<>();

    public int lengthList() {
        int number = 0;
        try {
            System.out.println("Введите число: ");
            number = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException");
        }
        return number;
    }

    public List<Integer> createList(final int length) {
        for (int i = 0; i < length; i++)
            System.out.println(list.add((int) (Math.random() * 100) - 50) + " " + list.get(i));
        return list;
    }

    public void testList(final List<Integer> list) {
        int sum = 0;
        try {
            if (list.size() == 0) {
                Integer.parseInt(null);
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                int element = list.get(i);
                if (element > 0) {
                    sum += element;
                }
            }
        }catch (NumberFormatException e) {
            System.out.println("NumberFormatException");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException");
        } finally {
            System.out.println(sum);
        }
    }
}
