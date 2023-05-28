package com.prodius.module3.lesson22hw.builder;

import com.prodius.module3.lesson22hw.module.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class StudentBuilder {
    public void loadDataFromFile(SessionFactory sessionFactory) {
        final InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("lesson22hw/student.csv");
        try (final BufferedReader reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(resourceAsStream)))
        ) {
            final Session session = sessionFactory.openSession();
            session.beginTransaction();
            String line;
            while ((line = reader.readLine()) != null) {
                final String[] parts = line.split(",");
                final String id = parts[0];
                final String name = parts[1];
                final String surname = parts[2];
                final String email = parts[3];

                final DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                java.sql.Date data = new java.sql.Date(df.parse(parts[4]).getTime());

                final int age = Integer.parseInt(parts[5]);
                Student student = student(id, name, surname, email, String.valueOf(data), age);
                session.save(student);
                System.out.println(student);
            }
            session.getTransaction().commit();
            session.close();
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public Student student(String id,String name, String surname, String email, String data, int age) throws ParseException {
        final Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setSurname(surname);
        student.setEmail(email);
        student.setDateOfBirth(Date.valueOf(data));
        student.setAge(age);

        return student;
    }
}