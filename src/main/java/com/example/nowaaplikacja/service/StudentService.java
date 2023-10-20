package com.example.nowaaplikacja.service;

import com.example.nowaaplikacja.data.Student;
import com.example.nowaaplikacja.data.StudentRepo;
import com.example.nowaaplikacja.data.StudentUnit;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student createStudent(Student student) {
        var index = createIndex(student.getUnit());
        var studentToSave = new Student(student.getId(), student.getName(), student.getUnit(), student.getIndex());
        studentRepo.createStudent(studentToSave);
        return studentToSave;
    }

    public Optional<Student> getStudentById(UUID id) {
        return studentRepo.getStudentById(id);
    }

    public void deleteByName(String name) {
        studentRepo.deleteByName(name);
    }

    private Long createIndex(StudentUnit unit){
        if(StudentUnit.GDANSK.equals(unit)){
            return 5 * studentRepo.findByMaxIndex();
        } else {
            return 10* studentRepo.findByMaxIndex();
        }
    }
}
