package com.example.nowaaplikacja.data;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepoTest {
    @Test
    void givenEmptyStudentsListTest() {
        List<Student> students = Collections.emptyList();
        var repository = new StudentRepo();
        repository.setStudents(students);

        var index = repository.findByMaxIndex();

       assertEquals(index, 0L);
    }
}