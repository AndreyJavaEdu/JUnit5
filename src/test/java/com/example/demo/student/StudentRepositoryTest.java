package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository underTest;

    //После каждого теста мы удаляем все сущности из таблиц БД.
    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckIfWhenStudentEmailExists() {
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

    @Test
    void itShouldCheckIfStudentEmailDoesNotExists() {
        //given
        String email = "jenia@gmaIil.com";

        //when
        Boolean expected = underTest.selectExistsEmail(email);

        //then
        assertThat(expected).isFalse();
    }
}