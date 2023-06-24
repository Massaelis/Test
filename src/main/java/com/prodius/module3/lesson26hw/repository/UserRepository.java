package com.prodius.module3.lesson26hw.repository;

import com.prodius.module3.lesson26hw.config.HibernateFactoryUtil;
import com.prodius.module3.lesson26hw.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserRepository implements Crud<User> {
    public final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
    public final Session session = sessionFactory.openSession();

    @Override
    public User save(User user) {
        try (final Session session = sessionFactory.openSession()) {
            Transaction t = session.beginTransaction();
            session.save(user);
            t.commit();

            System.out.println("Save: " + user);
        }
        return user;
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
    public User update(String id) {
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public void deleteOfId(String id) {
        try (final Session session = sessionFactory.openSession()) {
            Transaction t = session.beginTransaction();
            User s = session.get(User.class, id);
            session.delete(s);

            t.commit();
            System.out.println("Deleted: " + s);
        }
    }
}