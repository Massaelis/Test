package com.prodius.module3.module3.action;


import com.prodius.module3.module3.config.HibernateFactoryUtil;
import com.prodius.module3.module3.config.UserInputUtil;
import com.prodius.module3.module3.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SearchTeacher implements Command {
    private final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
    private static final Logger logger = LoggerFactory.getLogger(SearchTeacher.class);

    @Override
    public void execute() {
        final String name = UserInputUtil.getUserString("Print name teacher: ");
        final String surname = UserInputUtil.getUserString("Print surname teacher: ");
        try (final Session session = sessionFactory.openSession()) {
            session.createNativeQuery("SELECT * FROM teacher\n" +
                            "WHERE (name LIKE :name)\n" +
                            "OR (surname LIKE :surname)", Teacher.class)
                    .setParameter("name", name)
                    .setParameter("surname", surname)
                    .getResultList()
                    .forEach(System.out::println);
        }
        logger.info("User search teacher with name {}, surname {} ", name, surname);
    }
}