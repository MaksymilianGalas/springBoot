package com.example.nowaaplikacja.service;

import com.example.nowaaplikacja.data.Student;
import com.example.nowaaplikacja.data.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void createStudent(Student student) {
        studentRepo.createStudent(student);
    }

    public Optional<Student> getStudentById(UUID id) {
        return studentRepo.getStudentById(id);
    }

    public void deleteByName(String name) {
        studentRepo.deleteByName(name);
    }
}
