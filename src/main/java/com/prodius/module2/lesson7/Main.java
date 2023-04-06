package com.prodius.module2.lesson7;

public class Main {
    public static void main(String[] args) {
//        Thread.setDefaultUncaughtExceptionHandler(new GlobalHandler());

        someAction1("null");
        System.out.println(111);

        Integer a = null;
        a.byteValue();
    }

    private static void someAction1(String line) {
        someAction(line);
    }

    private static void someAction(String line) {
        line.substring(1);
    }
}

class GlobalHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(final Thread t, final Throwable e) {
        if (e instanceof Error) {
            System.out.println("So strong error");
        } else {
            System.out.println("No so strong error");
        }
    }
}
