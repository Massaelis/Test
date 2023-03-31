package com.prodius.lesson11hw.treeSet;

import java.util.*;

public class Menu {
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        Scanner scan = new Scanner(System.in);

        final java.util.TreeSet<TreeSet.Person> person = new java.util.TreeSet<>(Comparator.comparingInt(o -> o.age));
        Set<TreeSet.Person> reversePerson = person.descendingSet();


        int value;

        String menu = "Menu\n"
                + "1 - Просмотреть все объекты в TreeSet в порядке возрастания\n"
                + "2 - Просмотреть все объекты в TreeSet в порядке убывания\n"
                + "3 - Добавить новый объект в TreeSet\n"
                + "4 - Удалить объект из TreeSet\n"
                + "5 - Проверить, содержит ли TreeSet определенный объект\n"
                + "6 - Выйти из программы\n";

        System.out.println(menu);

        boolean isQuit = false;
        while (!isQuit) {
            byte functuion = scan.nextByte();

            switch (functuion) {
                case 1 -> System.out.println("TreeSet по возрастанию: " + person);
                case 2 -> System.out.println("TreeSet по убыванию: " + reversePerson);
                case 3 -> {
                    System.out.println("Добавить объект: ");
                    scan.nextLine();
                    value = scan.nextInt();
                    person.add(new TreeSet.Person(value));
                    System.out.println(person);
                }
                case 4 -> {
                    System.out.println("Удалить объект: ");
                    scan.nextLine();
                    value = scan.nextInt();
                    person.remove(new TreeSet.Person(value));
                    System.out.println(person);
                }
                case 5 -> {
                    System.out.println("Находится ли объект: ");
                    scan.nextLine();
                    value = scan.nextInt();
                    System.out.println(person.contains(new TreeSet.Person(value)));
                }
                case 6 -> isQuit = true;
                default -> System.out.println("Нет такой опции.");
            }
            System.out.println(menu);
        }
    }
}
