package org.example.service;

import org.example.api.Student;

import java.util.List;

public interface StudentService {
    List<Student> loadStudents();
    void saveStudent(Student student);
    Student getStudent(int id);
    void upDateStudent(Student student);
    void deleteStudent(int id);
}
