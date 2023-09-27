package com.prodius.module4.module4;

import com.prodius.module4.module4.threads.MyThreadStarter;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThreadStarter starter = new MyThreadStarter();
        starter.start();
    }
}