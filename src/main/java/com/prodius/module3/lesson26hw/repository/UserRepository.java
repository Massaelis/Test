package com.prodius.module3.lesson26hw.repository;

import com.prodius.module3.lesson26hw.config.HibernateFactoryUtil;
import com.prodius.module3.lesson26hw.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserRepository implements Crud<String, User, Integer> {
    final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();

    @Override
    public void create(User user) {
        try (final Session session = sessionFactory.openSession()) {
            Transaction t = session.beginTransaction();
            session.save(user);
            t.commit();

            System.out.println("Create: " + user);
        }
    }
    @Override
    public void read() {
        try (final Session session = sessionFactory.openSession()) {
            session.createNativeQuery("SELECT * FROM person ORDER BY name", User.class)
                    .list()
                    .forEach(System.out::println);
        }
    }
    @Override
    public void updateNameOfId(String before, String after) {
        try (final Session session = sessionFactory.openSession()) {
            Transaction t = session.beginTransaction();
            User s = session.get(User.class, before);
            s.setName(after);
            session.save(s);

            t.commit();
            System.out.println("Updated name: " + s);
        }
    }
    @Override
    public void updateAgeOfId(String before, Integer after) {
        try (final Session session = sessionFactory.openSession()) {
            Transaction t = session.beginTransaction();
            User s = session.get(User.class, before);
            s.setAge(after);
            session.save(s);

            t.commit();
            System.out.println("Updated age: " + s);
        }
    }
    @Override
    public void deleteOfId(String value) {
        try (final Session session = sessionFactory.openSession()) {
            Transaction t = session.beginTransaction();
            User s = session.get(User.class, value);
            session.delete(s);

            t.commit();
            System.out.println("Deleted: " + s);
        }
    }
}