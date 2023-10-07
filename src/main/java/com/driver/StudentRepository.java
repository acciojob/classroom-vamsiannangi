package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
    Map<String,Student> studentMap=new HashMap<>();
    Map<String,Teacher> teacherMap=new HashMap<>();
    Map<Teacher, List<Student>> studentTeacherMap=new HashMap<>();

    public void addData(){
Student student1=new Student("vamsi",20,75.5);
Student student2=new Student("sai",24,80);
        Student student3=new Student("krish",24,80);

Teacher teacher1=new Teacher("jhon",50,29);
        Teacher teacher2=new Teacher("kelvin",50,28);


        addStudentTeacherPair(student1, teacher1);
        addStudentTeacherPair(student2, teacher2);
        addStudentTeacherPair(student3, teacher2);
      addStudent(student1);
      addStudent(student2);
        addStudent(student3);
        addTeacher(teacher1);
      addTeacher(teacher2);
    }
    public void addStudentTeacherPair(Student student, Teacher teacher) {
        if (!studentTeacherMap.containsKey(teacher)) {
            studentTeacherMap.put(teacher, new ArrayList<>());
        }

        List<Student> studentsForTeacher = studentTeacherMap.get(teacher);
        studentsForTeacher.add(student);
    }
    public void addStudent(Student student) {
            studentMap.put(student.getName(),student);

    }

    public void addTeacher(Teacher teacher) {
            teacherMap.put(teacher.getName(),teacher);

    }


    public void addStudentTeacherPair(String studentName, String teacherName) {
        Teacher teacher1=new Teacher();
        Student student = studentMap.get(studentName);
        Teacher teacher = teacherMap.get(teacherName);

        if(student!=null && teacher!=null){
            if(studentTeacherMap.containsKey(teacher)){
                List<Student> studentsList=studentTeacherMap.get(teacher);
                if(studentsList.size()<teacher.getNumberOfStudents()){
                 studentsList.add(student);
                }
                else{
                    System.out.println("teacher has maximum students");
                }
            } else  {
                List<Student> students = new ArrayList<>();
                studentTeacherMap.put(teacher,students);
            }
        }
        else {
            System.out.println("Student or teacher not found.");
        }

//        List<Student> studentsForTeacher = studentTeacherMap.get(teacher);
//
//        if (studentsForTeacher.contains(student)) {
//            System.out.println("Student '" + student.getName() + "' already added to Teacher '" + teacher.getName() + "'.");
//        } else {
//            // Add the student to the teacher
//            studentsForTeacher.add(student);
//        }
    }

    public Student getByStudentByName(String name) {
        Student student=studentMap.get(name);
        return student;
    }

    public Teacher getTeacherByName(String name) {
        Teacher teacher=teacherMap.get(name);
        return teacher;
    }
    public List<String> getStudentByTeacher(String teacherName) {
        Teacher teacher = teacherMap.get(teacherName);
        List<String> studentsList = new ArrayList<>();

        List<Student> students = studentTeacherMap.get(teacher);

        if (students != null) {
            for (Student student : students) {
                String studentName = student.getName();
                studentsList.add(studentName);
            }
        }

        return studentsList;
    }

    public List<String> getAllStudents() {
        return new ArrayList<>(studentMap.keySet());

    }

    public void deleteTeacherByName(String teacher) {
        if(teacherMap.containsKey(teacher)){
            teacherMap.remove(teacher);
            deleteTeacherByNamePrint();
        }
    }
    public void deleteTeacherByNamePrint() {
        System.out.println(teacherMap.keySet());
    }

    public void deleteAllTeacher() {
        teacherMap.clear();
    }
}
