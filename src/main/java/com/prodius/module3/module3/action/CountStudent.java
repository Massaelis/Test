package com.prodius.module3.module3.action;

import com.prodius.module3.module3.config.HibernateFactoryUtil;
import com.prodius.module3.module3.dto.CountStudentDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountStudent implements Command {
    private final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();

    private static final Logger logger = LoggerFactory.getLogger(CountStudent.class);

    @Override
    public void execute() {
        try (final Session session = sessionFactory.openSession()) {
            session.createNativeQuery("SELECT\n" +
                            "groups_name AS name,\n" +
                            "count(surname) AS student_count\n" +
                            "FROM student\n" +
                            "INNER JOIN groups ON groups.name = student.groups_name\n" +
                            "GROUP BY groups_name")
                    .setResultTransformer(Transformers.aliasToBean(CountStudentDto.class))
                    .getResultList()
                    .forEach(System.out::println);
        }
        logger.info("User search count students");
    }
}