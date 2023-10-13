package com.dgmf.controller;

import com.dgmf.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // @Controller + @ResponseBody
public class StudentController {
    // Rest API that handles GET Request with ResponseEntity
    // GET Request: http://localhost:8080/student
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student student = Student.builder()
                .id(1L)
                .firstName("Karl-Heinz")
                .lastName("Rummenigge")
                .build();

        return ResponseEntity
                .ok()
                .header("custom-header", "Heinz")
                .body(student);
    }

    // Rest API that handles GET Request with ResponseEntity
    // GET Request : http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(2L, "Alex", "Gomez"));
        students.add(new Student(3L, "Guy", "Stewart"));
        students.add(new Student(4L, "Francis", "Pedro"));
        students.add(new Student(5L, "Nolan", "Howard"));
        students.add(new Student(6L, "Edmond", "Lopez"));

        return ResponseEntity
                .ok()
                .header("custom-header", "Gomez")
                .body(students);
    }

    // Rest API that handles GET Request with ResponseEntity
    // {id} ==> URI Template Variable
    // GET Request : http://localhost:8080/students/7/Howard/Hugues
    @GetMapping("/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(
            @PathVariable("id") Long studentId,
            @PathVariable("first-name") String studentFirstName,
            @PathVariable("last-name") String studentLastName
    ) {
        Student student = Student.builder()
                .id(studentId)
                .firstName(studentFirstName)
                .lastName(studentLastName)
                .build();

        return ResponseEntity
                .ok()
                .header("custom-header", "Gomez")
                .body(student);
    }

    // Rest API that handles GET Request with ResponseEntity
    // Rest API with Request Params
    // GET Request :
    // http://localhost:8080/students/query?id=1&firstname=Franck&lastname=Dodo
    @GetMapping("/query")
    public ResponseEntity<Student> studentRequestVariable(
            @RequestParam("id") Long studentId,
            @RequestParam("firstname") String studentFirstName,
            @RequestParam("lastname") String studentLastName
    ) {
        Student student = Student.builder()
                .id(studentId)
                .firstName(studentFirstName)
                .lastName(studentLastName)
                .build();

        return ResponseEntity
                .ok()
                .header("custom-header", "Gomez")
                .body(student);
    }

    // Rest API that handles POST Request with ResponseEntity
    // Rest API that handles HTTP Post Request - Creating new resource
    @PostMapping("/create")
    // @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student studentDTO) {
        Student student = Student.builder()
                .id(studentDTO.getId())
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .build();

        return new ResponseEntity<>(student, HttpStatus.CREATED);

    }

    // Rest API that handles HTTP PUT Request with ResponseEntity - Updating
    // existing resource
    // {id} ==> URI Template variables
    @PutMapping("/{id}/update")
    public ResponseEntity<Student> updateStudent(
            @PathVariable("id") Long studentId,
            @RequestBody Student studentRequested
    ) {
        Student student = Student.builder()
                .id(studentId)
                .firstName(studentRequested.getFirstName())
                .lastName(studentRequested.getLastName())
                .build();

        return ResponseEntity
                .ok()
                .header("custom-header", "Gomez")
                .body(student);
    }

    // Rest API that handles HTTP DELETE Request with ResponseEntity - Deleting
    // existing resource
    // {id} ==> URI Template variables
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudent(
            @PathVariable("id") Long studentId) {
        return ResponseEntity
                .ok()
                .header("custom-header", "Gomez")
                .body("Student with id " + studentId + " Deleted Successfully");
    }
}
