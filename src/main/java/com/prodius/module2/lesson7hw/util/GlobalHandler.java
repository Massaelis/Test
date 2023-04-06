package com.prodius.module2.lesson7hw.util;

public class GlobalHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(final Thread t, final Throwable e) {
        if (e instanceof RuntimeException) {
            System.out.println("Critical error occurred");
        }
    }
}
