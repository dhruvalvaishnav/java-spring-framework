package com.demo.spring.data.jpa.demo.repository;

import com.demo.spring.data.jpa.demo.entity.Guardian;
import com.demo.spring.data.jpa.demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .studentId(1L).emailId("dhruv@gmail.com").firstName("Dhruval").lastName("V")
//                .guardianEmail("sam@gmail.com").guardianName("Sam").guardianMobileNumber("1234567890")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder().name("shivam").mobileNumber("7854129632").email("shivam@gmail.com").build();

        Student student = Student.builder()
                .studentId(2L).emailId("dhiraj@gmail.com").firstName("Dhiraj").lastName("Ken")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }


    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("students list = " + studentList);
    }

    @Test
    public void printStudentsByFirstName() {
        String firstName = "Dhruval";
        List<Student> students = studentRepository.findByFirstName(firstName);
        System.out.println("List of students by their firstname = '" + firstName + "' is = " + students);
    }

    @Test
    public void printStudentsByFirstNameContaining() {
        String name = "D";
        List<Student> students = studentRepository.findByFirstNameContaining(name);
        System.out.println("List of students by their firstname = '" + name + "' is = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        String guardianName = "sam";
        List<Student> students = studentRepository.findByGuardianName(guardianName);
        System.out.println("List of students by their guardianName = '" + guardianName + "' is = " + students);
    }

    @Test
    public void printStudentByLastName() {
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println("List of students by their lastName not null = " + students);
    }

    @Test
    public void printStudentByEmailAddress() {
        String email = "dhruv@gmail.com";
        Student student = studentRepository.getStudentByEmailAddress(email);
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress() {
        String email = "dhruv@gmail.com";
        String firstNameByEmailAddress = studentRepository.getStudentFirstNameByEmailAddress(email);
        System.out.println("Student's first name = " + firstNameByEmailAddress);
    }

    @Test
    public void printStudentByEmailAddressNative() {
        String email = "dhruv@gmail.com";
        Student student = studentRepository.getStudentByEmailAddressNative(email);
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam() {
        String email = "dhruv@gmail.com";
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam(email);
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentFirstNameByEmailIdTest() {
        String firstName = "DHRUVAL V";
        String email = "dhruv@gmail.com";
        studentRepository.updateStudentFirstNameByEmailId(firstName, email);
//        System.out.println("Updated Student = " + studentRepository.getStudentByEmailAddress(email));
    }


}