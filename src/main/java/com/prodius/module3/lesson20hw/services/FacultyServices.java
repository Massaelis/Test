package com.prodius.module3.lesson20hw.services;


import com.prodius.module3.lesson20hw.model.Faculty;
import com.prodius.module3.lesson20hw.repository.Crud;

public class FacultyServices {
    private final Crud<Faculty, String> facultyRepository;

    public FacultyServices(Crud<Faculty, String> facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public void save(final Faculty faculty){
        facultyRepository.save(faculty);
    }

    public void printAll() {
        facultyRepository.getAll().forEach(System.out::println);
    }
}
