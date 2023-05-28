package com.prodius.module3.lesson22hw.builder;

import com.prodius.module3.lesson22hw.config.HibernateFactoryUtil;
import com.prodius.module3.lesson22hw.module.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class StudentBuilder {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public void loadDataFromFile() {
        final InputStream resourceAsStream = this.getClass().getClassLoader()
                .getResourceAsStream("lesson22hw/student.csv");
        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        try (final BufferedReader reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(resourceAsStream)));
             final Session session = sessionFactory.openSession()
        ) {
            session.beginTransaction();
            String line;
            while ((line = reader.readLine()) != null) {
                Student student = buiildStudent(line);
                session.save(student);
                System.out.println(student);
            }
            session.getTransaction().commit();
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Student buiildStudent(final String line) {
        final String[] parts = line.split(",");

        final Student student = new Student();
        student.setId(parts[0]);
        student.setName(parts[1]);
        student.setSurname(parts[2]);
        student.setEmail(parts[3]);
        student.setDateOfBirth(LocalDate.parse(parts[4], formatter));
        student.setAge(Integer.parseInt(parts[5]));

        return student;
    }
}