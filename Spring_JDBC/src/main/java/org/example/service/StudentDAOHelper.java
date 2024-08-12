package org.example.service;


import org.example.api.Student;
import org.example.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("studentDAOHelper")
public class StudentDAOHelper {
    @Autowired
    private StudentDAO studentDAOImpl;

    public void setUpStudentTable(){
        Student student1 = new Student();
        student1.setRoolNo(1);
        student1.setName("York");
        student1.setAddress("Paris");

        Student student2 = new Student();
        student2.setRoolNo(2);
        student2.setName("Jack");
        student2.setAddress("London");

        Student student3 = new Student();
        student3.setRoolNo(3);
        student3.setName("Mike");
        student3.setAddress("Rome");

        Student student4 = new Student();
        student4.setRoolNo(4);
        student4.setName("Raq");
        student4.setAddress("Rome");

        Student student5 = new Student();
        student5.setRoolNo(5);
        student5.setName("Jak");
        student5.setAddress("Rome");

        ArrayList<Student> students = new ArrayList<Student>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);


        studentDAOImpl.insert(students);
    }

    public void printStudentTable(List<Student> students){
        for(Student student : students){
            System.out.println(student);
        }
    }

    public void printStudentTable(Map<String, List<Student>> students, String str){
        List<Student> studentList = students.get(str);
        for(Student student : studentList){
            System.out.println(student);
        }
    }
}
