package com.prodius.module3.lesson26hw.repository;

import com.prodius.module3.lesson26hw.config.HibernateFactoryUtil;
import com.prodius.module3.lesson26hw.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserRepository implements Crud<User> {
    private final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();

    @Override
    public User create(User user) {
        try (final Session session = sessionFactory.openSession()) {
            Transaction t = session.beginTransaction();
            session.save(user);
            t.commit();
        }
        return user;
    }

    @Override
    public void update(User user) {
        try (final Session session = sessionFactory.openSession()) {
            Transaction t = session.beginTransaction();
            session.update(user);
            t.commit();
        }
    }

    @Override
    public List<User> getAll() {
        try (final Session session = sessionFactory.openSession()) {
            return session.createNativeQuery("SELECT * FROM person ORDER BY name", User.class)
                    .list();
        }
    }

    @Override
    public User getById(String id) {
        try (final Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        }
    }

    @Override
    public void deleteOfId(String id) {
        try (final Session session = sessionFactory.openSession()) {
            Transaction t = session.beginTransaction();
            User s = session.get(User.class, id);
            session.delete(s);
            t.commit();
        }
    }
}