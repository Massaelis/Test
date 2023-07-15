package com.prodius.module3.module3.action;


import com.prodius.module3.module3.config.UserInputUtil;
import com.prodius.module3.module3.model.Teacher;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SearchTeacher implements Command {

    private static final Logger logger = LoggerFactory.getLogger(SearchTeacher.class);

    @Override
    public void execute() {
        final String name = UserInputUtil.getUserString("Print name or surname teacher: ");
        try (final Session session = sessionFactory.openSession()) {
            session.createNativeQuery("SELECT * FROM teacher\n" +
                            "WHERE (name LIKE :name)\n" +
                            "OR (surname LIKE :name)", Teacher.class)
                    .setParameter("name", name)
                    .getResultList()
                    .forEach(System.out::println);
        }
        logger.info("User search teacher with name {}, surname {} ", name, name);
    }
}