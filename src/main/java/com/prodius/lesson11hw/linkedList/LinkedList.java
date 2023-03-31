package com.prodius.lesson11hw.linkedList;


public class LinkedList<T> implements List<T> {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addFirst(10);
        linkedList.addLast(30);
        linkedList.addLast(40);
        linkedList.addFirst(5);

        System.out.println("list  " + linkedList);

        System.out.println(linkedList.get(30));
        linkedList.remove(10);

        System.out.println("list  " + linkedList);

        linkedList.set(1, 100);
        System.out.println("list  " + linkedList);
    }
    private Node<T> head;

    @Override
    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
    }

    @Override
    public void addLast(T value) {
        if (head == null) {
            head = new Node<>(value);
        }
        Node<T> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node<>(value);
    }

    @Override
    public void remove(T value) {
        if (head == null) {
            return;
        }
        if (head.value == value) {
            head = head.next;
            return;
        }
        Node<T> currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.value == value) {
                currentNode.next = currentNode.next.next;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    @Override
    public int get(T value) {
        if (head == null) {
            return -1;
        }
        if (head.value == value) {
            return 0;
        }
        Node<T> currentNode = head;
        int result = 0;
        while (currentNode.next != null) {
            ++result;
            if (currentNode.next.value == value) {
                return result;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public void set(int index, T element) {
        Node<T> node = getNodeByIndex(index);
        node.value = element;
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


    @Override
    public String toString() {
        return "LinkedList{" + "head=" + head + '}';
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" + "value=" + value + ", next=" + next + '}';
        }
    }
}

