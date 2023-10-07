package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
@Autowired
private StudentRepository studentRepository;

    public void addTeacher(Teacher teacher) {

        studentRepository.addTeacher(teacher);
    }

    public void addStudent(Student student) {
        studentRepository.addData();

        studentRepository.addStudent(student);
    }


    public void addStudentTeacherPair(String student, String teacher) {
        studentRepository.addData();
studentRepository.addStudentTeacherPair(student,teacher);
    }

    public Student getStudentbyName(String name) {
        studentRepository.addData();
        return studentRepository.getByStudentByName(name);
    }

    public Teacher getTeacherByName(String name) {
        studentRepository.addData();
return studentRepository.getTeacherByName(name);
    }

    public List<String> getStudentByTeacher(String teacher) {
        studentRepository.addData();
return studentRepository.getStudentByTeacher(teacher);
    }

    public List<String> getAllStudents() {
        studentRepository.addData();
        return studentRepository.getAllStudents();
    }

    public void deleteTeacherByName(String teacher) {
        studentRepository.addData();
       studentRepository.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers() {
        studentRepository.addData();
        studentRepository.deleteAllTeacher();

    }
}
