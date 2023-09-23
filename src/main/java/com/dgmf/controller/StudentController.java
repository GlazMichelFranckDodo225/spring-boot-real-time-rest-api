package com.dgmf.controller;

import com.dgmf.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
