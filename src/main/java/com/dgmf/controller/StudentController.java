package com.dgmf.controller;

import com.dgmf.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController // @Controller + @ResponseBody
public class StudentController {
    // HTTP GET Request : http://localhost:8080/student
    @GetMapping("/student")
    public Student getStudent() {
        Student student = Student.builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .build();

        return student;
    }

    // HTTP GET Request : http://localhost:8080/students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        Student student1 = Student.builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .build();

        Student student2 = Student.builder()
                .id(2L)
                .firstName("Emily")
                .lastName("Stewart")
                .build();

        Student student3 = Student.builder()
                .id(3L)
                .firstName("Patrick")
                .lastName("Dupuy")
                .build();

        students.add(student1);
        students.add(student2);
        students.add(student3);

        return students;
    }

    // REST API with Path Variable
    // HTTP GET Request : http://localhost:8080/students/1/John/Doe
    // {id}, {first-name} and {last-name} ==> URI Template variables
    @GetMapping("/students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(
            @PathVariable("id") Long studentId,
            @PathVariable("first-name") String studentFirstName,
            @PathVariable("last-name") String studentLastName
    ) {
        Student student = Student.builder()
                .id(studentId)
                .firstName(studentFirstName)
                .lastName(studentLastName)
                .build();

        return student;
    }

    // Rest API that handles GET Request
    // Rest API with Request Params
    // GET Request :
    // http://localhost:8080/students/query?id=1&firstname=Franck&lastname=Dodo
    @GetMapping("/students/query")
    public Student studentRequestVariable(
            @RequestParam("id") Long studentId,
            @RequestParam("firstname") String studentFirstName,
            @RequestParam("lastname") String studentLastName
    ) {
        Student student = Student.builder()
                .id(studentId)
                .firstName(studentFirstName)
                .lastName(studentLastName)
                .build();

        return student;
    }
}
