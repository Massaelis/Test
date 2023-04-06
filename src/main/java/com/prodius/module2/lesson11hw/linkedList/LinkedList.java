package com.prodius.module2.lesson11hw.linkedList;


import java.util.Objects;
import java.util.Optional;

public class LinkedList<T> implements List<T> {
    private Node<T> head;

    private Node<T> last;

    @Override
    public void addFirst(final T value) {
        Node<T> newNode = new Node<>(value);
        if (head == last && last == null) {
            last = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    @Override
    public void addLast(final T value) {
        Node<T> newNode = new Node<>(value);
        if (head == last && head == null) {
            head = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
        }
        last = newNode;
    }

    @Override
    public void remove(final T value) {
        if (head == null || last == null) {
            return;
        }

        if (head.value == value) {
            final Node<T> removed = head;
            head = head.next;
            deleteNode(removed);
            return;
        }

        if (last.value == value) {
            final Node<T> removed = last;
            last = last.prev;
            deleteNode(removed);
            return;
        }

        Node<T> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;

            if (currentNode.value == value) {
                deleteNode(currentNode);
                return;
            }

        }
    }

    private void deleteNode(final Node<T> node) {
        Objects.requireNonNull(node);

        final Node<T> prev = node.prev;
        final Node<T> next = node.next;

        node.prev = null;
        node.next = null;

        Optional.ofNullable(prev).ifPresent(tNode -> tNode.next = next);
        Optional.ofNullable(next).ifPresent(tNode -> tNode.prev = prev);
    }

    @Override
    public int indexOf(final T value) {
        if (head == null) {
            return -1;
        }

        if (head.value == value) {
            return 0;
        }

        Node<T> currentNode = head;
        int result = 0;
        while (currentNode.next != null) {
            result++;
            final Node<T> next = currentNode.next;
            if (next.value == value) {
                return result;
            }
            currentNode = next;
        }
        return -1;
    }

    @Override
    public void set(int index, final T element) {
        getNodeByIndex(index).ifPresent(tNode -> tNode.value = element);
    }

    @Override
    public void add(final int index, final T t) {
        if (index < 0) {
            throw new IllegalArgumentException("Index must be positive");
        }

        if (head == null || last == null || index == 0) {
            addFirst(t);
            return;
        }

        getNodeByIndex(index).ifPresentOrElse(
                tNode -> addNode(tNode, t),
                () -> addLast(t)
        );
    }

    private void addNode(final Node<T> currentNode, final T t) {
        Objects.requireNonNull(currentNode);

        final Node<T> newNode = new Node<>(t);
        final Node<T> prev = currentNode.prev;

        Optional.ofNullable(prev).ifPresent(tNode -> tNode.next = newNode);
        newNode.prev = prev;
        newNode.next = currentNode;
        currentNode.prev = newNode;
    }

    private Optional<Node<T>> getNodeByIndex(final int index) {
        if (index < 0 || head == null) {
            return Optional.empty();
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++, current = current.next) {
            if (current == null) {
                return Optional.empty();
            }
        }
        return Optional.of(current);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            sb.append(current.value).append(" ");
            current = current.next;
        }

        return String.format("LinkedList: {%s}", sb);
    }

    private static class Node<T> {
        private T value;

        private Node<T> next;

        private Node<T> prev;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("Node: {%s}", value);
        }
    }
}

