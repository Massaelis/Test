package com.prodius.module3.lesson25hw.service;

import com.prodius.module3.lesson25hw.model.Course;
import com.prodius.module3.lesson25hw.model.Student;
import com.prodius.module3.lesson25hw.repository.StudentRepository;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentService {
    private static final Random RANDOM = new Random();

    private final StudentRepository repository;

    private static StudentService instance;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public static StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService(StudentRepository.getInstance());
        }
        return instance;
    }

    public Set<ObjectId> createAndSave(final int count) {
        if (count <= 0 || count > 100) {
            throw new IllegalArgumentException("count must be between 1 and 100");
        }

        Set<Student> student = new HashSet<>();
        for (int i = 0; i < count; i++) {
            student.add(created());
        }
        repository.insertMany(student);
        return student.stream()
                .map(Student::getId)
                .collect(Collectors.toSet());
    }

    private Student created() {
        return new Student(
                ObjectId.get(),
                "Student-" + RANDOM.nextInt(100),
                LocalDate.now().minusDays(RANDOM.nextInt(1000)).plusDays(RANDOM.nextInt(1000)),
                createdSetCourse()
        );
    }

    public List<Course> createdSetCourse() {
        List<Course> course = new ArrayList<>();
        for (int i = 0; i < RANDOM.nextInt(4); i++) {
            course.add(createdCourse());
        }
        return course;
    }

    private Course createdCourse() {
        return new Course(
                ObjectId.get(),
                "Course-" + RANDOM.nextInt(100),
                "Description-" + RANDOM.nextInt(100)
        );
    }

    public Set<Student> getAll() {
        return repository.findAll();
    }

    public void updateOfId(String id) {
        repository.updateOfId(id);
    }

    public void deleteOfId(String id) {
        repository.deleteOfId(id);
    }
}