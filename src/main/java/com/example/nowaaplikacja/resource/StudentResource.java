package com.example.nowaaplikacja.resource;

import com.example.nowaaplikacja.data.Student;
import com.example.nowaaplikacja.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/students")
public class StudentResource {
    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public void createStudent(Student student){

    }
}
