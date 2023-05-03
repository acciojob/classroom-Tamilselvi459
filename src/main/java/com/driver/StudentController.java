package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentservice;
    @PostMapping("/add-student") //1
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        studentservice.addStudent(student);
        return new ResponseEntity<>("New student added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-teacher") //2
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher){
       studentservice.addTeacher(teacher);
        return new ResponseEntity<>("New teacher added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/add-student-teacher-pair") //3
    public ResponseEntity<String> addStudentTeacherPair(@RequestParam String student, @RequestParam String teacher){
       studentservice.addStudentTeacherPair(student , teacher);
        return new ResponseEntity<>("New student-teacher pair added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-student-by-name/{name}") //4
    public ResponseEntity<Student> getStudentByName(@PathVariable String name){

        Student student = studentservice.getStudentByName(name); // Assign student by calling service layer method

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping("/get-teacher-by-name/{name}") //5
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable String name){
        Teacher teacher = studentservice.getTeacherByName(name);// Assign student by calling service layer method

        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    @GetMapping("/get-students-by-teacher-name/{teacher}") //6
    public ResponseEntity<List<String>> getStudentsByTeacherName(@PathVariable String teacher){
        List<String> students = studentservice.getStudentByTeacherName(teacher); // Assign list of student by calling service layer method

        return new ResponseEntity<>(students, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-students") //7
    public ResponseEntity<List<String>> getAllStudents(){
        List<String> students = studentservice.getAllStudents(); // Assign list of student by calling service layer method

        return new ResponseEntity<>(students, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-teacher-by-name") //8
    public ResponseEntity<String> deleteTeacherByName(@RequestParam String teacher){
        studentservice.deleteTeacherByName(teacher);
        return new ResponseEntity<>(teacher + " removed successfully", HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-all-teachers") //9
    public ResponseEntity<String> deleteAllTeachers(){
        studentservice.deleteAllTeacher();
        return new ResponseEntity<>("All teachers deleted successfully", HttpStatus.CREATED);
    }
}
