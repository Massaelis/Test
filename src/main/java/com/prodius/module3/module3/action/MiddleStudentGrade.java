package com.prodius.module3.module3.action;

import com.prodius.module3.module3.config.HibernateFactoryUtil;
import com.prodius.module3.module3.config.UserInputUtil;
import com.prodius.module3.module3.dto.MiddleGradeDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

public class MiddleStudentGrade implements Command {
    private final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();

    @Override
    public void execute() {
        final int grade = UserInputUtil.getUserInt("Print grade: ");
        try (final Session session = sessionFactory.openSession()) {
            session.createNativeQuery("SELECT\n" +
                            "student.name,\n" +
                            "AVG(grade ) AS middle_grade\n" +
                            "FROM student\n" +
                            "JOIN grade ON grade.student_surname = student.surname\n" +
                            "WHERE(grade > :grade)\n" +
                            "GROUP BY name")
                    .setResultTransformer(Transformers.aliasToBean(MiddleGradeDto.class))
                    .setParameter("grade", grade)
                    .getResultList()
                    .forEach(System.out::println);
        }
        Commands.logger.info("User search student with grade {}", grade);
    }
}
