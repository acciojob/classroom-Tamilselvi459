package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {
    HashMap<String , Student> studentmap = new HashMap<>();
    HashMap<String , Teacher> teachermap = new HashMap<>();

    HashMap<String , String > pairmap = new HashMap<>();
   // HashMap<String , List<>>

    public void addStudent(Student student) {

        studentmap.put(student.getName() , student);
    }

    public void addTeacher(Teacher teacher) {

        teachermap.put(teacher.getName() , teacher);
    }

    public Optional<Student> getStudent(String student) {
        if(studentmap.containsKey(student)){

            return Optional.of(studentmap.get(student));
        }
        return Optional.empty();

    }

    public Optional<Teacher> getTeacher(String teacher) {
        if(teachermap.containsKey(teacher)){
            return Optional.of(teachermap.get(teacher));
        }
        return Optional.empty();
    }

    public void addstudentTeacherPair(String student, String teacher) {

        pairmap.put(student , teacher);
    }

    public Student getStudentByName(String name) {
        Student student = studentmap.get(name);
          return student;
        }

    public Teacher getTeacherByName(String name) {

      Teacher teacher = teachermap.get(name);
        return teacher;
    }

    public List<String> getStudentByTeacherName(String teacher) {
        List<String> ans = new ArrayList<>();
        for(String name : pairmap.keySet()){
            if(pairmap.get(name).equals(teacher)) ans.add(name);
        }
        return ans;
    }

    public List<String> getAllStudents() {
        List<String> ans = new ArrayList<>();
        for(String name : studentmap.keySet()){
            ans.add(name);
        }
        return ans;
    }

    public void deleteTeacherByName(String teacher) {
        teachermap.remove(teacher);
        List<String> ans = getStudentByTeacherName(teacher);
        for(String name : ans){
            pairmap.remove(name);
            studentmap.remove(name);
        }
    }
    public List<String> getAllTeacher(){
       List<String> ans = new ArrayList<>();
       for(String name : teachermap.keySet()){
           ans.add(name);
       }
       return ans;
    }


    public void deleteAllTeacher() {
        List<String> ans = getAllStudents();
        for(String name : ans) {
            studentmap.remove(name);
            pairmap.remove(name);
        }
        List<String> teacher = getAllTeacher();
        for(String name : teacher) teachermap.remove(name);
    }
}
