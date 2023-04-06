package com.prodius.module2.lesson11hw.linkedList;

public class Main {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();

        linkedList.addFirst(10);
        linkedList.addFirst(11);
        linkedList.addFirst(12);
        linkedList.addLast(30);
        linkedList.addLast(40);
        linkedList.addFirst(5);

        System.out.println(linkedList);
        System.out.println(linkedList.toString2());

        linkedList.remove(10);
        System.out.println(linkedList);
        linkedList.remove(15);
        System.out.println(linkedList);
        linkedList.remove(5);
        System.out.println(linkedList);
        linkedList.remove(40);
        System.out.println(linkedList);


        System.out.println(linkedList.indexOf(30));

        linkedList.set(5, 100);
        System.out.println(linkedList);
        linkedList.set(0, 100);
        System.out.println(linkedList);
        linkedList.set(2, 300);
        System.out.println(linkedList);

        linkedList.add(1, 101);
        System.out.println(linkedList);
        linkedList.add(0, 102);
        System.out.println(linkedList);
    }
}
