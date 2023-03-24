package com.prodius.lesson9hw;

import com.prodius.lesson9hw.stack.StackMethod;

public class Main {
    public static void main(String[] args) {
        StackMethod<String> stack = new StackMethod<>(String.class, 10);

        stack.push("2g");
        stack.push("4f");
        stack.push("6d");
        stack.push("8s");

        System.out.println(stack.pop());

        System.out.println(stack.peek());

        System.out.println(stack.isEmpty());

        System.out.println(stack.isFull());

        System.out.println(stack.size());

        printStack(stack);

        System.out.println();

        StackMethod<Integer> stackInt = new StackMethod<>(Integer.class, 10);

        stackInt.push(1);
        stackInt.push(2);
        stackInt.push(3);
        stackInt.push(4);
        stackInt.push(5);

        System.out.println(stackInt.pop());

        printStack(stackInt);

    }

    private static <E> void printStack(StackMethod<E> stack) {
        while (!stack.isEmpty()) {
            E value = stack.pop();
            System.out.print(value + "; ");
        }
    }
}
