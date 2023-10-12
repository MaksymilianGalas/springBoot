package com.example.nowaaplikacja.resource;

import com.example.nowaaplikacja.data.Student;
import com.example.nowaaplikacja.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/students")
public class StudentResource {
    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable UUID id){
        var student = studentService.getStudentById(id);
        if(student != null){
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }
}
