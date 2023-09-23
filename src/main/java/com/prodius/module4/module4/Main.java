package com.prodius.module4.module4;

import com.prodius.module4.module4.config.HibernateFactoryUtil;
import com.prodius.module4.module4.threads.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThreadStarter starter = new MyThreadStarter();
        starter.start();

        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        final Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        session1.save(starter.createDetails());
        session1.getTransaction().commit();
        session1.close();
    }
}