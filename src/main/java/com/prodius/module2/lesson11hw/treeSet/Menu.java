package com.prodius.module2.lesson11hw.treeSet;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Menu {
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        Scanner scan = new Scanner(System.in);

        final TreeSet<Person> person = new TreeSet<>(Comparator.comparingInt(o -> o.getAge()));
        final NavigableSet<Person> descendingSet = person.descendingSet();

        String menu = "Menu\n"
                + "1 - Просмотреть все объекты в Person в порядке возрастания\n"
                + "2 - Просмотреть все объекты в Person в порядке убывания\n"
                + "3 - Добавить новый объект в Person\n"
                + "4 - Удалить объект из Person\n"
                + "5 - Проверить, содержит ли Person определенный объект\n"
                + "6 - Выйти из программы\n";


        boolean isQuit = false;
        while (!isQuit) {
            System.out.println(menu);
            int number = scan.nextInt();

            switch (number) {
                case 1 -> System.out.println("Person по возрастанию: " + person);
                case 2 -> System.out.println("Person по убыванию: " + descendingSet);
                case 3 -> {
                    System.out.println("Добавить объект: ");
                    scan.nextLine();
                    final int value = scan.nextInt();
                    person.add(new Person(value));
                    System.out.println(person);
                }
                case 4 -> {
                    System.out.println("Удалить объект: ");
                    scan.nextLine();
                    final int value = scan.nextInt();
                    person.removeIf(person1 -> person1.getAge() == value);
                    System.out.println(person);
                }
                case 5 -> {
                    System.out.println("Находится ли объект: ");
                    scan.nextLine();
                    final int value = scan.nextInt();
                    final boolean contains = contains(person, value);
                    System.out.println(contains);
                }
                case 6 -> isQuit = true;
                default -> System.out.println("Нет такой опции.");
            }
        }
    }

    private static boolean contains(final TreeSet<Person> person, final int value) {
        for (Person p : person) {
            if (p.getAge() == value) {
                return true;
            }
        }
        return false;
    }
}
