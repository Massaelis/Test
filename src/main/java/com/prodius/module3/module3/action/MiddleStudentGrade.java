package com.prodius.module3.module3.action;

import com.prodius.module3.module3.config.UserInputUtil;
import com.prodius.module3.module3.dto.MiddleGradeDto;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MiddleStudentGrade implements Command {
    private static final Logger logger = LoggerFactory.getLogger(MiddleStudentGrade.class);

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
        logger.info("User search student with grade {}", grade);
    }
}
