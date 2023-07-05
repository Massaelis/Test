package com.prodius.module3.module3;


import com.prodius.module3.module3.config.FlywayUtil;
import com.prodius.module3.module3.config.HibernateFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        t.commit();

        FlywayUtil.initMigration();
    }
}
