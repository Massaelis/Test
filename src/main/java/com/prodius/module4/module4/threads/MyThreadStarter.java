package com.prodius.module4.module4.threads;

import static com.prodius.module4.module4.threads.MyThreadsForDetails.details;

public class MyThreadStarter {
    public void start() throws InterruptedException {
        final Thread robot1 = new MyThreadForFuel();
        robot1.setDaemon(true);
        robot1.start();

        final Thread robot5 = new MyThreadsForRobot5();
        robot5.start();

        final Thread robot2 = new MyThreadsForDetails(details);
        final Thread robot3 = new MyThreadsForDetails(details);
        robot2.start();
        robot3.start();
        robot2.join();
        robot3.join();

        final Thread robot4 = new MyThreadForSchema();
        robot4.start();
    }
}
