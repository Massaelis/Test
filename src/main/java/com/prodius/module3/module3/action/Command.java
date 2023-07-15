package com.prodius.module3.module3.action;

import com.prodius.module3.module3.config.HibernateFactoryUtil;
import org.hibernate.SessionFactory;

public interface Command {
    void execute();

    SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
}