package com.example.nowaaplikacja.Service;

import com.example.nowaaplikacja.data.Student;
import com.example.nowaaplikacja.data.StudentRepo;
import com.example.nowaaplikacja.data.StudentUnit;
import com.example.nowaaplikacja.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private StudentRepo studentRepo;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp(){
        when(studentRepo.findByMaxIndex()).thenReturn(5L);
    }
    @Test
    void givenStudentWithUnitGdanskWhenCreateStudentThenStudentWasSavedWithValidData(){
        var student = new Student(UUID.randomUUID(), "Maksiu", StudentUnit.GDANSK, null);


        var savedStudent = studentService.createStudent(student);

        assertEquals(student.getId(), savedStudent.getId());
        assertEquals(student.getName(), savedStudent.getName());
        assertEquals(student.getUnit(), savedStudent.getUnit());
        assertEquals(25L, savedStudent.getIndex());
        verify(studentRepo, times(1)).findByMaxIndex();
    }

    @Test
    void givenStudentWithUnitWarsawWhenCreateStudentThenStudentWasSavedWithValidData(){
        var student = new Student(UUID.randomUUID(), "Maksiu", StudentUnit.WARSZAWA, null);
        ArgumentCaptor<Student> captor = ArgumentCaptor.forClass(Student.class);

        var savedStudent = studentService.createStudent(student);

        assertEquals(student.getId(), savedStudent.getId());
        assertEquals(student.getName(), savedStudent.getName());
        assertEquals(student.getUnit(), savedStudent.getUnit());
        assertEquals(50L, savedStudent.getIndex());
        verify(studentRepo, times(1)).findByMaxIndex();
        verify(studentRepo, times(1)).createStudent(captor.capture());
        var studentArg = captor.getValue();
        assertEquals(student.getId(), studentArg.getId());
        assertEquals(student.getName(), studentArg.getName());
        assertEquals(student.getUnit(), studentArg.getUnit());
        assertEquals(50L, studentArg.getIndex());
    }
}
