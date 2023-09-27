package com.prodius.module4.module4.threads;

import com.prodius.module4.module4.config.HibernateFactoryUtil;
import com.prodius.module4.module4.model.Details;
import com.prodius.module4.module4.model.FuelTruck;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

public class MyThreadStarter {

    public void start() throws InterruptedException {
        final FuelTruck fuelTruck = new FuelTruck();
        final MyThreadForFuel robot1 = new MyThreadForFuel(fuelTruck);
        robot1.setDaemon(true);

        long time = System.currentTimeMillis();
        robot1.start();

        final Thread robot2 = new MyThreadsForDetails();
        final Thread robot3 = new MyThreadsForDetails();
        robot2.start();
        robot3.start();
        robot2.join();
        robot3.join();

        final Thread robot4 = new MyThreadForSchema();
        robot4.start();
        robot4.join();

        final Thread robot5 = new MyThreadsForRobot5(fuelTruck);
        robot5.start();
        robot5.join();
        robot1.cansel();

        final long timeWork = (System.currentTimeMillis() - time) / 1000;
        System.out.println("Time in seconds " + timeWork);

        createAndSaveDetails(timeWork, fuelTruck);
    }

    private void createAndSaveDetails(final long timeWork, final FuelTruck fuelTruck) {
        final Details details = new Details();

        details.setDate(LocalDate.now());
        details.setTime(timeWork);
        details.setFuel(fuelTruck.getUsedFuel());
        details.setBrokeSchemas(MyThreadForSchema.getBrokeSchemas());

        System.out.println(details);
        save(details);
    }

    private void save(final Details details) {
        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        final Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        session1.save(details);
        session1.getTransaction().commit();
        session1.close();
    }
}