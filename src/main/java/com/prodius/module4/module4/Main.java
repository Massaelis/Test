package com.prodius.module4.module4;

import com.prodius.module4.module4.threads.*;

import static com.prodius.module4.module4.threads.MyThreadsForDetails.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThreadStarter starter = new MyThreadStarter();
        starter.start();
    }
}
