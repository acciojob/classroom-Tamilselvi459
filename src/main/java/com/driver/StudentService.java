package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentrepository;

    public void addStudent(Student student) {
        studentrepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        studentrepository.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        Optional<Student> a = studentrepository.getStudent(student);
        Optional<Teacher> t = studentrepository.getTeacher(teacher);
        if(a.isPresent() && t.isPresent()) {
            studentrepository.addstudentTeacherPair(student,teacher);
        }
    }

    public Student getStudentByName(String name) {
       return studentrepository.getStudentByName(name);
    }

    public Teacher getTeacherByName(String name) {
        return studentrepository.getTeacherByName(name);
    }

    public List<String> getStudentByTeacherName(String teacher) {
        return studentrepository.getStudentByTeacherName(teacher);
    }

    public List<String> getAllStudents() {
        return studentrepository.getAllStudents();
    }

    public void deleteTeacherByName(String teacher) {
        studentrepository.deleteTeacherByName(teacher);
    }

    public void deleteAllTeacher() {
        studentrepository.deleteAllTeacher();
    }
}
