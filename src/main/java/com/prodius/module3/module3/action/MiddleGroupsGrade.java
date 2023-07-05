package com.prodius.module3.module3.action;

import com.prodius.module3.module3.config.HibernateFactoryUtil;
import com.prodius.module3.module3.dto.MiddleGroupsGradeDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

public class MiddleGroupsGrade implements Command {
    private final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();

    @Override
    public void execute() {
        try (final Session session = sessionFactory.openSession()) {
            session.createNativeQuery("    SELECT groups.name,\n" +
                            "AVG(grade) as middle_grade\n" +
                            "from groups\n" +
                            "INNER JOIN student ON groups.name = student.groups_name\n" +
                            "INNER JOIN grade ON grade.student_surname = student.surname\n" +
                            "GROUP BY groups.name")
                    .setResultTransformer(Transformers.aliasToBean(MiddleGroupsGradeDto.class))
                    .getResultList()
                    .forEach(System.out::println);
        }
        Commands.logger.info("User search middle group grade");
    }
}