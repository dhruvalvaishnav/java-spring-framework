package com.demo.spring.data.jpa.demo.repository;

import com.demo.spring.data.jpa.demo.entity.Course;
import com.demo.spring.data.jpa.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;


@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course courseDBA = Course.builder().title("DBA").credit(5).build();

        Course courseJava = Course.builder().title("Java").credit(6).build();

        Teacher teacher = Teacher.builder()
                            .firstName("John")
                            .lastName("Doe")
//                            .courses(Arrays.asList(courseDBA, courseJava))
                .build();

        teacherRepository.save(teacher);
    }
}