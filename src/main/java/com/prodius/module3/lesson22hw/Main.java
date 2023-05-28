package com.prodius.module3.lesson22hw;

import com.prodius.module3.lesson22hw.builder.QueryBuilder;
import com.prodius.module3.lesson22hw.builder.StudentBuilder;
import com.prodius.module3.lesson22hw.config.HibernateFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        StudentBuilder studentBuilder = new StudentBuilder();
        studentBuilder.loadDataFromFile(sessionFactory);
        final Session session = sessionFactory.openSession();

        QueryBuilder.query(session);
    }
}