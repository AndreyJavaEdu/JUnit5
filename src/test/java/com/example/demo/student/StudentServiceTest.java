package com.example.demo.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class StudentServiceTest {
    @Mock
    private StudentRepository repository;
    private AutoCloseable autoCloseable;
    private StudentService underTest;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(StudentServiceTest.class);
        underTest = new StudentService(repository);
    }

    @Test
    void canGetAllStudents() {

    }

    @Test
    @Disabled
    void addStudent() {
    }

    @Test
    @Disabled
    void deleteStudent() {
    }
}