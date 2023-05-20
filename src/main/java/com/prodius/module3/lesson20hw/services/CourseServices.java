package com.prodius.module3.lesson20hw.services;

import com.prodius.module3.lesson20hw.model.Course;
import com.prodius.module3.lesson20hw.repository.CourseRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

public class CourseServices {
    private final CourseRepository courseRepository;

    public CourseServices(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void loadDataFromFile(final String filename) {
        final InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(filename);
        try (final BufferedReader reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(resourceAsStream)))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String[] parts = line.split(",");
                final String id = parts[0];
                final String group_name = parts[1];

                final DateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                java.sql.Date dateStart = new java.sql.Date(df.parse(parts[2]).getTime());
                java.sql.Date dateEnd = new java.sql.Date(df.parse(parts[3]).getTime());

                final String id_faculty = parts[4];
                final Course course = new Course(id, group_name, dateStart, dateEnd, null, id_faculty);
                courseRepository.save(course);
                System.out.println(course);
            }
        } catch (RuntimeException e) {
            System.out.println("Duplicate key value violates unique constraint \"faculty_pkey\"");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public Set<Object> getDataAboutCourse() {
        return courseRepository.getDataAboutCourse();
    }
}