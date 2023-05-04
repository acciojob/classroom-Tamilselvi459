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

    HashMap<String , List<String> > pairmap = new HashMap<>();
   // HashMap<String , List<>>

    public void addStudent(Student student) {

        studentmap.put(student.getName() , student);
    }

    public void addTeacher(Teacher teacher) {

        teachermap.put(teacher.getName() , teacher);
    }



    public void addStudentTeacherPair(String student, String teacher) {

        List<String> ans = new ArrayList<>();
        if(pairmap.containsKey(teacher)) ans = pairmap.get(teacher);
        ans.add(student);
        pairmap.put(teacher , ans);
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
       return pairmap.get(teacher);
    }

    public List<String> getAllStudents() {
        List<String> ans = new ArrayList<>();
        for(String name : studentmap.keySet()){
            ans.add(name);
        }
        return ans;
    }

    public void deleteTeacherByName(String teacher) {

        for(String a : pairmap.get(teacher)){
            studentmap.remove(a);
        }
        teachermap.remove(teacher);
        pairmap.remove(teacher);
    }



    public void deleteAllTeacher() {
        for(String a: teachermap.keySet()){
            for(String an : pairmap.get(a)){
                studentmap.remove(an);
            }
            teachermap.remove(a);
            pairmap.remove(a);
        }
    }
}
