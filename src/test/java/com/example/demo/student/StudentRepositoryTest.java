package com.example.demo.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;


class StudentRepositoryTest {
    @Autowired
    private StudentRepository underTest;

    @Test
    void itShouldCheckIfStudentExistsEmail() {
        //given
        String email = "jenia@gmaIil.com";
        Student student = new Student(
                "Jenia",
                email,
                Gender.FEMALE
        );
        underTest.save(student);
        //when
        Boolean expected = underTest.selectExistsEmail(email);

        //then
        assertThat(expected).isTrue();
    }
}